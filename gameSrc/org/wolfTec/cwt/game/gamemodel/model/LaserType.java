package org.wolfTec.cwt.game.gamemodel.model;

import org.wolftec.validation.IntValue;

public class LaserType {
  @IntValue(min = 1, max = 9)
  public int damage;
}
