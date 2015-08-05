package org.wolftec.cwt.actions.gameactions;

import org.wolftec.cwt.actions.Action;
import org.wolftec.cwt.actions.ActionData;
import org.wolftec.cwt.actions.ActionType;
import org.wolftec.cwt.actions.UserInteractionData;
import org.wolftec.cwt.logic.TeamLogic;
import org.wolftec.cwt.model.ModelManager;

public class TransferUnit implements Action {

  private TeamLogic    team;
  private ModelManager model;

  @Override
  public String key() {
    return "transferUnit";
  }

  @Override
  public ActionType type() {
    return ActionType.UNIT_ACTION;
  }

  // TODO relation: ["S", "T", relation.RELATION_SAME_THING],

  @Override
  public boolean condition(UserInteractionData data) {
    return team.canTransferUnit(data.source.unit);
  }

  @Override
  public boolean hasSubMenu() {
    return true;
  }

  @Override
  public void prepareMenu(UserInteractionData data) {
    team.getUnitTransferTargets(data.source.unit.owner, data);
  }

  @Override
  public void fillData(UserInteractionData interactionData, ActionData actionData) {
    actionData.p1 = interactionData.source.unitId;
    actionData.p2 = interactionData.actionDataCode;
  }

  @Override
  public void invoke(ActionData data) {
    team.transferUnitToPlayer(model.getUnit(data.p1), model.getPlayer(data.p2));
  }

}
