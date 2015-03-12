package org.wolfTec.cwt.game.action;

import org.wolftec.validation.DataObject;
import org.wolftec.validation.IntValue;
import org.wolftec.validation.StringValue;

/**
 * Action entry. Used to handle actions in a asynchronous way plus sending and
 * receiving them via a network interface.
 */
@DataObject
public class ActionItem {

  @IntValue
  private int actionId;

  @IntValue
  private int p1;

  @IntValue
  private int p2;

  @IntValue
  private int p3;

  @IntValue
  private int p4;

  @IntValue
  private int p5;

  @StringValue
  private String pStr;
}
