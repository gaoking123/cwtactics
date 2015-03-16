package org.wolftec.cwtactics.system.localization;

import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.wolftec.core.Injected;
import org.wolftec.core.JsExec;
import org.wolftec.core.ManagedComponent;
import org.wolftec.core.ManagedConstruction;
import org.wolftec.log.Logger;
import org.wolftec.persistence.JsonConverter;
import org.wolftec.persistence.VirtualFilesystemManager;

/**
 * 
 */
@ManagedComponent
public class LocalizationManager {

  @ManagedConstruction
  private Logger log;

  @Injected
  private VirtualFilesystemManager vfs;

  @Injected
  private JsonConverter converter;

  /**
   * The current active language.
   */
  private Map<String, String> language;

  public void autoSelectLanguage(Callback0 cb) {
    selectLanguage(getBrowserLanguage(), cb);
  }

  /**
   * 
   * @return language that is set in the active browser like "de"
   */
  public String getBrowserLanguage() {
    return JsExec.injectJS("navigator.language || navigator.userLanguage");
  }

  /**
   * Selects a language by it's key.
   */
  public void selectLanguage(String language, Callback0 cb) {
    vfs.readKey("lang/lang_" + language, converter, (err, langFile) -> {
      if (langFile.value != null) {
        this.language = langFile.value;
        cb.$invoke();

      } else {
        log.error("Could not load language from file system");
      }
    });
  }

  /**
   * Returns the localized string of a given identifier.
   */
  public String solveKey(String key) {
    String str = language.$get(key);
    return str != JSGlobal.undefined ? str : key;
  }
}
