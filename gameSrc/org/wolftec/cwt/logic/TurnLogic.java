package org.wolftec.cwt.logic;

import org.wolftec.cwt.Constants;
import org.wolftec.cwt.core.Log;
import org.wolftec.cwt.core.config.ConfigurableValue;
import org.wolftec.cwt.core.config.ConfigurationProvider;
import org.wolftec.cwt.core.ioc.Injectable;
import org.wolftec.cwt.core.util.JsUtil;
import org.wolftec.cwt.model.gameround.ModelManager;
import org.wolftec.cwt.model.gameround.Player;

public class TurnLogic implements Injectable, ConfigurationProvider {

  private Log log;

  private ModelManager model;
  private FogLogic     fog;

  private ConfigurableValue round_dayLimit;

  @Override
  public void onConstruction() {
    round_dayLimit = new ConfigurableValue("game.limits.days", 0, 999, 0);
  }

  /**
   * 
   * @param player
   */
  public void startsTurn(Player player) {
    model.turnOwner = player;

    log.info("player " + player.id + " starts his turn");

    // Sets the new turn owner and also the client, if necessary
    if (player.clientControlled) {
      model.lastClientPlayer = player;
    }

    // *************************** Update Fog ****************************

    // the active client can see what his and all allied objects can see
    int clTid = model.lastClientPlayer.team;
    for (int i = 0, e = Constants.MAX_PLAYER; i < e; i++) {
      Player cPlayer = model.getPlayer(i);

      cPlayer.turnOwnerVisible = false;
      cPlayer.clientVisible = false;

      // player isn't registered
      if (cPlayer.team == Constants.INACTIVE) {
        continue;
      }

      if (cPlayer.team == clTid) {
        cPlayer.clientVisible = true;
      }
      if (cPlayer.team == player.team) {
        cPlayer.turnOwnerVisible = true;
      }
    }

    model.forEachUnit((index, unit) -> {
      boolean turnStarterObject = unit.owner == player;
      unit.canAct = turnStarterObject ? true : false;
    });

    fog.fullRecalculation();
  }

  /**
   * Ends the turn for the current active turn owner.
   */
  public void stopTurn() {
    int pid = model.turnOwner.id;
    int oid = pid;

    log.info("player " + pid + " stops his turn");

    // Try to find next player from the player pool
    pid++;
    while (pid != oid) {

      if (pid == Constants.MAX_PLAYER) {
        pid = 0;

        // Next day
        model.day++;
        model.weatherLeftDays--;

        // TODO: into action
        int dayLimit = round_dayLimit.value;
        if (dayLimit > 0 && model.day >= dayLimit) {
          // cwt.Update.endGameRound();
          // TODO
        }
      }

      // Found next player
      if (model.getPlayer(pid).team != Constants.INACTIVE) {
        break;
      }

      // Try next player
      pid++;
    }

    // If the new player id is the same as the old
    // player id then the game aw2 is corrupted
    if (pid == oid) {
      JsUtil.throwError("IllegalGameState");
    }

    // Do end/start turn logic
    startsTurn(model.getPlayer(pid));
  }
}
