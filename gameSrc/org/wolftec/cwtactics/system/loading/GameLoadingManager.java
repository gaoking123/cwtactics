package org.wolftec.cwtactics.system.loading;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.wolftec.container.ContainerUtil;
import org.wolftec.core.ComponentManager;
import org.wolftec.core.Injected;
import org.wolftec.core.ManagedComponent;
import org.wolftec.core.ManagedComponentInitialization;

@ManagedComponent
public class GameLoadingManager implements ManagedComponentInitialization {

  @Injected
  private Array<ElementLoadedListener> _loadingListeners;

  @Injected
  // TODO priority
  private Array<GameLoadingHandler> _loadingHandlers;

  private Callback1<String> _triggerLoadingListeners;

  @Override
  public void onComponentConstruction(ComponentManager manager) {
    _triggerLoadingListeners = (name) -> {
      for (int i = 0; i < _loadingListeners.$length(); i++) {
        _loadingListeners.$get(i).onLoadingElement(name);
      }
    };

    _loadingHandlers.sort((a, b) -> {
      if (a.getLoadPriority() > b.getLoadPriority()) {
        return +1;
      } else if (a.getLoadPriority() < b.getLoadPriority()) {
        return -1;
      } else {
        return 0;
      }
    });
  }

  /**
   * 
   * @param callback
   */
  public void loadData(Callback0 callback) {
    ContainerUtil.forEachElementInListAsync(_loadingHandlers, (handler, next) -> {
      handler.loadStuff(_triggerLoadingListeners, next);
    }, callback);
  }
}
