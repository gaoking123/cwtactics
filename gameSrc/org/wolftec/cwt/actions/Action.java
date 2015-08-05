package org.wolftec.cwt.actions;

/**
 * Action class which represents an action which is usable by engine objects.
 */
public interface Action {

  /**
   * Key ID of the action.
   */
  String key();

  /**
   * Type of the action.
   */
  ActionType type();

  /**
   * Condition function which checks the availability of the action with the
   * current state data.
   */
  default boolean condition(UserInteractionData data) {
    return true;
  }

  default boolean hasSubMenu() {
    return false;
  }

  /**
   * Prepares the menu for a given state data.
   */
  default void prepareMenu(UserInteractionData data) {
  }

  /**
   * Checks the correctness of a given target position.
   */
  default boolean isTargetValid(UserInteractionData data) {
    return false;
  }

  /**
   * Adds all possible targets into the state selection.
   */
  default void prepareTargets(UserInteractionData data) {
  }

  /**
   * Marks the kind of the action. Multistep actions can flush more than one
   * command into the command stack.
   */
  default void multiStepAction() {
  }

  /**
   * Prepares the selection.
   */
  default void prepareSelection(UserInteractionData data) {

  }

  default PositionUpdateMode positionUpdateMode() {
    return PositionUpdateMode.SET_POSITION;
  }

  /**
   * Marks the target selection mode. Mode 'A' will be done before the sub menu.
   * Mode 'B' will be done after the sub menu.
   */
  default ActionTargetMode targetSelectionType() {
    return ActionTargetMode.A;
  }

  /**
   * If true, then flusher won't push a 'wait' command. This is only usable for
   * unit actions.
   */
  default boolean noAutoWait() {
    return false;
  }

  default boolean checkSource(PositionCheck unitFlag, PositionCheck propertyFlag) {
    switch (type()) {

      case UNIT_ACTION:
        return unitFlag == PositionCheck.OWN;

      case PROPERTY_ACTION:
        return unitFlag != PositionCheck.OWN && propertyFlag == PositionCheck.OWN;

      case MAP_ACTION:
        return unitFlag != PositionCheck.OWN && propertyFlag != PositionCheck.OWN;

      case CLIENT_ACTION:
      case ENGINE_ACTION:
        return true;

      default:
        return false;
    }
  }

  default boolean checkTarget(PositionCheck unitFlag, PositionCheck propertyFlag) {
    return unitFlag == PositionCheck.EMPTY;
  }

  default boolean checkActionTarget(PositionCheck unitFlag, PositionCheck propertyFlag) {
    return unitFlag == PositionCheck.EMPTY;
  }

  default void fillData(UserInteractionData interactionData, ActionData actionData) {

  }

  /**
   * Invokes the action with a given set of arguments.
   */
  void invoke(ActionData data);
}
