package org.wolftec.cwtactics.game.map;

import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.wolftec.cwtactics.Entities;
import org.wolftec.cwtactics.game.EntityManager;
import org.wolftec.cwtactics.game.core.Asserter;
import org.wolftec.cwtactics.game.core.System;
import org.wolftec.cwtactics.game.event.LoadMap;

public class TileMapSystem implements System, LoadMap {

  private EntityManager em;
  private Asserter      asserter;

  @Override
  public void onLoadMap(String entity, Object rawData) {
    Map<String, Object> data = (Map<String, Object>) rawData;

    em.detachEntityComponentByClass(Entities.GAME_ROUND, TileMap.class);
    em.tryAcquireComponentFromDataSuccessCb(Entities.GAME_ROUND, data, TileMap.class, (map) -> {

      for (int x = 0; x < map.tiles.$length(); x++) {
        Array<String> column = map.tiles.$get(x);
        for (int y = 0; y < column.$length(); y++) {
          asserter.inspectValue("map tile {" + x + ", " + y + "}", column.$get(y)).isEntityId();
        }
      }
    });
  }
}
