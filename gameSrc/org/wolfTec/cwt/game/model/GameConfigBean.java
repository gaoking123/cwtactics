package org.wolfTec.cwt.game.model;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.wolfTec.cwt.game.EngineGlobals;
import org.wolfTec.cwt.game.model.types.GameConfigType;
import org.wolfTec.wolfTecEngine.assets.GameLoadHandler;
import org.wolfTec.wolfTecEngine.beans.Bean;
import org.wolfTec.wolfTecEngine.beans.Created;
import org.wolfTec.wolfTecEngine.beans.PostInitialization;
import org.wolfTec.wolfTecEngine.log.Logger;
import org.wolfTec.wolfTecEngine.persistence.FileDescriptor;
import org.wolfTec.wolfTecEngine.persistence.VirtualFilesystem;

@Bean
public class GameConfigBean implements GameLoadHandler {

  @Created("{name=$beanName}")
  private Logger log;

  @Created("{folder=/config}")
  private VirtualFilesystem fs;

  @Created
  private Map<String, Config> configs;
  
  @Created
  private Array<String> configNames;

  @PostInitialization
  public void init() { // TODO convert to data object
    
    // game logic
    createConfig("fogEnabled", new Config(0, 1, 1, 1), true);
    createConfig("daysOfPeace", new Config(0, 50, 0, 1), true);
    createConfig("weatherMinDays", new Config(1, 5, 1, 1), true);
    createConfig("weatherRandomDays", new Config(0, 5, 4, 1), true);
    createConfig("round_dayLimit", new Config(0, 999, 0, 1), true);
    createConfig("noUnitsLeftLoose", new Config(0, 1, 0, 1), true);
    createConfig("autoSupplyAtTurnStart", new Config(0, 1, 1, 1), true);
    createConfig("unitLimit", new Config(0, EngineGlobals.MAX_UNITS, 0, 5), true);
    createConfig("captureLimit", new Config(0, EngineGlobals.MAX_PROPERTIES, 0, 1), true);
    createConfig("timer_turnTimeLimit", new Config(0, 60, 0, 1), true);
    createConfig("timer_gameTimeLimit", new Config(0, 99999, 0, 5), true);
    createConfig("co_getStarCost", new Config(100, 50000, 9000, 100), true);
    createConfig("co_getStarCostIncrease", new Config(0, 50000, 1800, 100), true);
    createConfig("co_getStarCostIncreaseSteps", new Config(0, 50, 10, 1), true);
    createConfig("co_enabledCoPower", new Config(0, 1, 1, 1), true);

    // app config
    createConfig("fastClickMode", new Config(0, 1, 0, 1), false);
    createConfig("forceTouch", new Config(0, 1, 0, 1), false);
    createConfig("animatedTiles", new Config(0, 1, 1, 1), false);
  }

  private void createConfig(String name, Config cfg, boolean gameConfig) {
    configs.$put(name, cfg);
    if (gameConfig) configNames.push(name);
  }

  public Array<String> getConfigNames() {
    return configNames;
  }

  public Config getConfig(String key) {
    return configs.$get(key);
  }

  public Integer getConfigValue(String key) {
    return configs.$get(key).getValue();
  }

  /**
   * Resets all config values, except the application config values, back to
   * their default value.
   */
  public void resetConfig() {
    for (int i = 0; i < configNames.$length(); i++) {
      getConfig(configNames.$get(i)).resetValue();
    }
  }

  @Override
  public void onLoadingGamedata(Callback0 cb) {
    fs.readFile("user_data.json", (FileDescriptor<GameConfigType> entry) -> {
      GameConfigType config = entry.value;

      if (config != null) {
        log.info("Found user data... going to load it");

        getConfig("fastClickMode").setValue(config.fastClickMode ? 1 : 0);
        getConfig("forceTouch").setValue(config.forceTouch ? 1 : 0);
        getConfig("animatedTiles").setValue(config.animatedTiles ? 1 : 0);

      } else {
        log.info("No user data found... going use default data");
      }

      cb.$invoke();
    });
  }

  // TODO via interface ?
  public void saveConfiguration(Callback0 callback) {
    GameConfigType config = new GameConfigType();
    config.forceTouch = (getConfigValue("forceTouch") == 1);
    config.fastClickMode = (getConfigValue("fastClickMode") == 1);
    config.animatedTiles = (getConfigValue("animatedTiles") == 1);

    fs.writeFile("user_data.json", config, (data, err) -> {
      if (err != null) {
        log.warn("Could not write game configuration file");
      } 
      
      callback.$invoke();
    });
  }
}
