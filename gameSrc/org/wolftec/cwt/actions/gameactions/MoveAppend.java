package org.wolftec.cwt.actions.gameactions;

import org.wolftec.cwt.Constants;
import org.wolftec.cwt.actions.Action;
import org.wolftec.cwt.actions.ActionData;
import org.wolftec.cwt.actions.ActionType;
import org.wolftec.cwt.actions.UserInteractionData;

public class MoveAppend implements Action {

  private MoveActionData moveDto;

  @Override
  public String key() {
    return "moveAppend";
  }

  @Override
  public ActionType type() {
    return ActionType.ENGINE_ACTION;
  }

  @Override
  public void fillData(UserInteractionData positionData, ActionData actionData) {
    // TODO
  }

  @Override
  public void invoke(ActionData data) {
    if (data.p1 != Constants.INACTIVE) moveDto.movePath.push(data.p1);
    if (data.p2 != Constants.INACTIVE) moveDto.movePath.push(data.p2);
    if (data.p3 != Constants.INACTIVE) moveDto.movePath.push(data.p3);
    if (data.p4 != Constants.INACTIVE) moveDto.movePath.push(data.p4);
    if (data.p5 != Constants.INACTIVE) moveDto.movePath.push(data.p5);
  }
}
