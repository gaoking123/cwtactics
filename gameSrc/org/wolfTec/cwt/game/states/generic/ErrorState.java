package org.wolfTec.cwt.game.states.generic;

import org.stjs.javascript.Date;
import org.stjs.javascript.dom.Form;
import org.stjs.javascript.dom.Input;
import org.wolfTec.cwt.game.renderer.beans.UserInterfaceLayerBean;
import org.wolfTec.managed.Injected;
import org.wolfTec.managed.ManagedComponent;
import org.wolfTec.wolfTecEngine.components.CreatedType;
import org.wolfTec.wolfTecEngine.logging.Logger;
import org.wolfTec.wolfTecEngine.statemachine.State;
import org.wolfTec.wolfTecEngine.statemachine.StateManager;
import org.wolfTec.wolfTecEngine.util.BrowserUtil;

@ManagedComponent
public class ErrorState implements State {

  // TODO by config
  public static final String ERROR_FORM_URL = "http://battle.customwars.com/report/index.php";

  // TODO use button group

  @CreatedType
  private Logger log;

  @Injected
  private UserInterfaceLayerBean ui;

  private String errorMessage;
  private boolean rendered;

  private int selectedAction;

  public void setErrorMessage(String message) {
    this.errorMessage = message;
  }

  @Override
  public void enter(StateManager stm) {
    rendered = false;
    errorMessage = "";
    selectedAction = 0;
  }

  private void sendErrorReport() {
    Form form = BrowserUtil.createDomElement("form");
    Input inputMsg = BrowserUtil.createDomElement("input");
    Input inputTitle = BrowserUtil.createDomElement("input");

    inputMsg.name = "problem";
    inputMsg.value = errorMessage;

    inputTitle.name = "title";
    inputTitle.value = "Autogenerated Error Report " + (new Date()).getTime();

    form.action = "post";
    form.target = ERROR_FORM_URL;
    form.appendChild(inputTitle);
    form.appendChild(inputMsg);
    form.submit();
  }
}
