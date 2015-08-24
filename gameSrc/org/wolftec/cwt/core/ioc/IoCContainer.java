package org.wolftec.cwt.core.ioc;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.wolftec.cwt.core.JsUtil;
import org.wolftec.cwt.core.ListUtil;
import org.wolftec.cwt.system.ClassUtil;
import org.wolftec.cwt.system.Log;
import org.wolftec.cwt.system.Nullable;

public class IoCContainer {

  private static final String     NON_IOC_CANDIDATE_CLASSNAMEPART = "Abstract";

  private Log                     log;

  private Map<String, Injectable> managedObjects;

  public void initByConfig(IoCConfiguration config) {
    Nullable.ifPresent(managedObjects, (value) -> JsUtil.throwError("AlreadyInitialized"));

    managedObjects = JSCollections.$map();

    /*
     * this class depends on initialized class names on all STJS classes ->
     * thats why we need to make sure that the given namespaces have classes
     * with injected class names... else our IoC container would not work
     */
    prepareNamespaces(config);

    log = new Log();
    log.onConstruction((Injectable) this);

    createManagedObjects(config);
    handleManagedDependencies();
    callConstructionEvent();
  }

  private void callConstructionEvent() {
    JsUtil.forEachMapValue(managedObjects, (instanceName, instance) -> {
      instance.onConstruction();
    });
  }

  private void handleManagedDependencies() {
    JsUtil.forEachMapValue(managedObjects, (instanceName, instance) -> {
      ClassUtil.forEachComplexPropertyOfInstance(instance, (prop, _ignored) -> {
        ClassUtil.searchClassPropertyType(ClassUtil.getClass(instance), prop, (propertyType) -> {

          if (propertyType == Array.class) {
            tryInjectArrayOfManagedObjects(instance, prop);
            return;

          }

          if (propertyType == Map.class) {
            tryInjectMapOfManagedObjects(instance, prop);
            return;
          }

          if (tryInjectManagedObject(instance, prop, propertyType)) {
            log.info("Injecting instance of " + ClassUtil.getClassName(propertyType) + " into " + instanceName + "." + prop);
            return;
          }

          if (tryInjectConstructedObject(instance, prop, propertyType)) {
            log.info("Injecting instance of " + ClassUtil.getClassName(propertyType) + " into " + instanceName + "." + prop);
            return;
          }

        }, () -> {
          /* leave property as it is because it seems not to be managed or known */
        });
      });
    });
  }

  private void tryInjectArrayOfManagedObjects(Injectable instance, String prop) {
    ClassUtil.searchClassPropertySubType(ClassUtil.getClass(instance), prop, 0, (propertyGenericType) -> {
      Array<Injectable> list = JSCollections.$array();
      JsUtil.forEachMapValue(managedObjects, (subInstanceName, subInstance) -> {
        if (ClassUtil.classImplementsInterface(ClassUtil.getClass(subInstance), propertyGenericType)) {
          log.info("Injecting instance of " + subInstanceName + " into the list " + ClassUtil.getClassName(instance) + "." + prop);
          list.push(subInstance);
        }
      });
      JSObjectAdapter.$put(instance, prop, list);
    }, () -> {

      /*
       * leave property as it is because it seems not to be managed or known
       */
    });
  }

  private void tryInjectMapOfManagedObjects(Injectable instance, String prop) {
    ClassUtil.searchClassPropertySubType(ClassUtil.getClass(instance), prop, 1, (propertyGenericType) -> {
      Map<String, Injectable> map = JSCollections.$map();
      JsUtil.forEachMapValue(managedObjects, (subInstanceName, subInstance) -> {
        if (ClassUtil.classImplementsInterface(ClassUtil.getClass(subInstance), propertyGenericType)) {
          log.info("Injecting instance of " + subInstanceName + " into the map " + ClassUtil.getClassName(instance) + "." + prop);
          map.$put(subInstanceName, subInstance);
        }
      });
      JSObjectAdapter.$put(instance, prop, map);
    }, () -> {

      /*
       * leave property as it is because it seems not to be managed or known
       */
    });
  }

  private boolean tryInjectConstructedObject(Injectable instance, String prop, Class<?> propertyType) {
    if (ClassUtil.classImplementsInterface(propertyType, Constructable.class)) {
      Constructable dependency = (Constructable) ClassUtil.newInstance(propertyType);
      dependency.onConstruction(instance);
      JSObjectAdapter.$put(instance, prop, dependency);
      return true;
    }
    return false;
  }

  private boolean tryInjectManagedObject(Injectable instance, String prop, Class<?> propertyType) {
    if (ClassUtil.classImplementsInterface(propertyType, Injectable.class)) {
      String propertyTypeName = ClassUtil.getClassName(propertyType);
      JSObjectAdapter.$put(instance, prop, Nullable.getOrThrow(managedObjects.$get(propertyTypeName), "MissingInjectable: " + propertyTypeName));
      return true;
    }
    return false;
  }

  private void prepareNamespaces(IoCConfiguration config) {
    ListUtil.forEachArrayValue(config.namespaces, (nsIndex, nsName) -> {
      ClassUtil.initClassNames(JSObjectAdapter.$get(Global.window, nsName));
    });
  }

  private void createManagedObjects(IoCConfiguration config) {
    ListUtil.forEachArrayValue(config.namespaces, (nsIndex, nsName) -> {
      Object namespace = JSObjectAdapter.$get(Global.window, nsName);

      ClassUtil.forEachClassOfNamespace(namespace, (className, classObject) -> {
        boolean isManaged = ClassUtil.classImplementsInterface(classObject, Injectable.class);
        boolean isAbstract = ClassUtil.getClassName(classObject).startsWith(NON_IOC_CANDIDATE_CLASSNAMEPART);

        if (isManaged && !isAbstract) {
          Nullable.ifPresent(managedObjects.$get(className), (value) -> JsUtil.throwError("ClassAlreadyManaged: " + className));

          /*
           * casting is okay here because isManaged proved that classObject is
           * an object of type Injectable
           */
          managedObjects.$put(className, (Injectable) ClassUtil.newInstance(classObject));
        }
      });
    });
  }

  public <T extends Injectable> T getManagedObjectByType(Class<T> clazz) {
    String className = ClassUtil.getClassName(clazz);
    return Nullable.getOrThrow((T) managedObjects.$get(className), "UnknownState: " + className);
  }
}
