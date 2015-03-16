package org.wolftec.cwtactics.game.model;

import org.stjs.javascript.Array;
import org.wolftec.validation.DataObject;
import org.wolftec.validation.validators.IntValue;
import org.wolftec.validation.validators.StringValue;

@DataObject
public class RocketSiloType {

  @StringValue(minLength = 1)
  public Array<String> fireable;
  
  @IntValue(min = 1, max = 9)
  public int damage;
  
  @IntValue(min = 1, max = 5)
  public int range;
}
