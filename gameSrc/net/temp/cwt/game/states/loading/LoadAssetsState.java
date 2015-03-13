package net.temp.cwt.game.states.loading;

import net.temp.cwt.game.persistence.beans.GameLoadingManager;
import net.temp.wolfTecEngine.logging.Logger;
import net.temp.wolfTecEngine.statemachine.State;
import net.temp.wolfTecEngine.statemachine.StateManager;

import org.wolftec.core.Injected;
import org.wolftec.core.ManagedComponent;
import org.wolftec.core.ManagedConstruction;

@ManagedComponent
public class LoadAssetsState implements State {

  @ManagedConstruction
  private Logger log;

  @Injected
  private GameLoadingManager loader;

  @Override
  public void enter(StateManager stm) {
    loader.start(filePath -> {
      showFileToCopy(filePath);
    }, () -> {
      stm.changeToStateClass(ValidateGameDataState.class);
    });
  }

  private void showFileToCopy(String filePath) {
    // TODO render file name
  }
}
