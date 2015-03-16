package org.wolftec.cwtactics.game.model;

import org.wolftec.validation.DataObject;
import org.wolftec.validation.validators.IntValue;

@DataObject
public class LaserType {
  
  @IntValue(min = 1, max = 9)
  public int damage;
}
