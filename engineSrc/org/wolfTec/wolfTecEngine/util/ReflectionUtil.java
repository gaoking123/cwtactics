package org.wolfTec.wolfTecEngine.util;

import java.lang.annotation.Annotation;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.Map;

public abstract class ReflectionUtil {

  public static Class<?> getClass(Object object) {
    return JsExec.injectJS("dataObject.constructor");
  }

  public static Array<Class<?>> getClassesWithAnnoation(String namespace, Class<? extends Annotation> annotation) {
    // TODO
    return null;
  }
  

  public static <T> T getClassInstance(Class<T> clazz) {
    return JsExec.injectJS("new clazz()");
  }
  
  public static void getMethodAnnotations (Class<?> clazz, String methodName) {
    // JSGlobal.stjs.getMemberAnnotation(clazz, methodName, null);
  }

  public static String getPropertyTypeAsName (Object object, String property) {
    Object typeDesc = JsExec.injectJS("object.constructor.$typeDescription");
    return JsExec.injectJS("typeDesc[property]"); // TODO simple name
  }
  
  public static String getSimpleName(Class<?> clazz) {
    return null; // TODO
  }

  public static boolean hasPropertyAnnotations (Class<?> clazz, String propertyName, Class<? extends Annotation> annot) {
    return JSGlobal.stjs.getMemberAnnotation(clazz, propertyName, getSimpleName(annot)) != null;
  }

  public static boolean isInstanceOf (Object obj, Class<?> clazz) {
    return JsExec.injectJS("obj isntanceOf clazz");
  }
  
  /**
   * 
   * @param obj
   * @return a list of property names that an object has
   */
  public static Array<String> objectKeys(Object obj) {
    return JsExec.injectJS("Object.keys(obj)");
  }

  public static void setProperty(Object object, String property, Object value) {
    JsExec.injectJS("object[property] = value");
  }
}
