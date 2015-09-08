package org.wolftec.cwt.input;

import org.stjs.javascript.functions.Callback2;
import org.wolftec.cwt.core.ioc.Injectable;

public class BlockedInputManager implements Injectable, InputProvider {

  @Override
  public boolean isActionPressed(String action) {
    return false;
  }

  @Override
  public boolean isButtonPressed(String button) {
    return false;
  }

  @Override
  public void forEachButtonMapping(Callback2<String, String> itCb) {

  }

}
