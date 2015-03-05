package org.wolfTec.renderer.sprite;

import org.stjs.javascript.Map;
import org.wolfTec.wolfTecEngine.container.ContainerUtil;

/**
 * 
 */
public class SpriteSizeMetrics {
  
  public SpriteSizeMetrics () {
    this.tileIndex = ContainerUtil.createMap();
  }
  
  /**
   * The width of one tile of the sprite
   */
  public int tileWidth;

  /**
   * The width of one tile of the sprite
   */
  public int tileHeight;
  
  /**
   * Contains the different indexes
   */
  public Map<String, Integer> tileIndex;
  
}
