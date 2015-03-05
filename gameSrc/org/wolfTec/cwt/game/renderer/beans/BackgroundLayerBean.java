package org.wolfTec.cwt.game.renderer.beans;

import org.wolfTec.cwt.game.EngineGlobals;
import org.wolfTec.managed.ManagedComponent;
import org.wolfTec.renderer.layer.GraphicLayer;
import org.wolfTec.renderer.layer.LayerFrameTime;
import org.wolfTec.renderer.layer.LayerFrames;
import org.wolfTec.renderer.layer.LayerIndex;
import org.wolfTec.renderer.sprite.Sprite;

/**
 * Background layer contains the background image of the screen. It's visible in
 * the menu and on maps which are smaller than the screen.
 */
@ManagedComponent
@LayerIndex(EngineGlobals.LAYER_BG)
@LayerFrames(EngineGlobals.LAYER_BG_FRAMES)
@LayerFrameTime(EngineGlobals.LAYER_BG_FRAMETIME)
public class BackgroundLayerBean extends GraphicLayer {

  @Override
  public int getIndex() {
    return EngineGlobals.LAYER_BG;
  }

  @Override
  public int getNumberOfFrames() {
    return EngineGlobals.LAYER_BG_FRAMES;
  }

  @Override
  public int getFrameTime() {
    return EngineGlobals.LAYER_BG_FRAMETIME;
  }

  /**
   * Renders a background image.
   * 
   * @param bg
   */
  public void renderBackgroundImage(Sprite bg) {
    clearDrawCanvas();

    // TODO stretch while protecting aspect ratio
    bg.drawStrechedSprite(0, ctx, 0, 0, cv.width, cv.height);
  }

}
