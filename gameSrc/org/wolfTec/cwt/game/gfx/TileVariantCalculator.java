package org.wolfTec.cwt.game.gfx;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.wolfTec.cwt.game.model.ConnectedTile;
import org.wolfTec.cwt.game.model.GameRoundBean;
import org.wolfTec.cwt.game.model.Tile;
import org.wolfTec.wolfTecEngine.beans.annotations.Bean;
import org.wolfTec.wolfTecEngine.beans.annotations.Injected;

@Bean
public class TileVariantCalculator {

  private Map<String, ConnectedTile> types;

  @Injected
  private GameRoundBean map;

  public TileVariantCalculator() {
    this.types = JSCollections.$map();
  }

  /**
   * Registers a tile variant information in the system.
   *
   * @param type
   *          ID of the tile where the variant information will be used
   * @param desc
   * @param connection
   */
  public void registerVariantInfo(String type, Map<String, String> desc,
      Array<Array<String>> connection) {
    types.$put(type, new ConnectedTile(desc, connection));
  }

  /**
   * Updates the variant number for every tile in the map.
   */
  public void updateTileSprites() {
    int xe = map.mapWidth;
    int ye = map.mapHeight;

    for (int x = 0; x < xe; x++) {
      for (int y = 0; y < ye; y++) {

        Tile tile = map.getTile(x, y);

        // tile has variants
        if (types.equals(tile.type.ID)) {
          tile.variant = types.$get(tile.type.ID).getVariant(

              // N
              (y > 0) ? map.getTile(x, y - 1).type.ID : "",

              // E
              (x < map.mapWidth - 1) ? map.getTile(x + 1, y).type.ID : "",

              // S
              (y < map.mapHeight - 1) ? map.getTile(x, y + 1).type.ID : "",

              // W
              (x > 0) ? map.getTile(x - 1, y).type.ID : "",

              // NE
              (y > 0 && x < map.mapWidth - 1) ? map.getTile(x + 1, y - 1).type.ID : "",

              // SE
              (y < map.mapHeight - 1 && x < map.mapWidth - 1) ? map.getTile(x + 1, y + 1).type.ID
                  : "",

              // SW
              (y < map.mapHeight - 1 && x > 0) ? map.getTile(x - 1, y + 1).type.ID : "",

              // NW
              (y > 0 && x > 0) ? map.getTile(x - 1, y - 1).type.ID : ""
          );
        } else {
          tile.variant = 0;
        }
      }
    }
  }
}
