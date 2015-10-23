package org.wolftec.cwt.test.tools;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.wolftec.cwt.core.test.Assert;
import org.wolftec.cwt.model.gameround.Player;
import org.wolftec.cwt.model.gameround.Property;
import org.wolftec.cwt.model.gameround.Tile;
import org.wolftec.cwt.model.gameround.Unit;

public class TestAssertion {

  private CwtTestManager parent;

  public TestAssertion(CwtTestManager parent) {
    this.parent = parent;
  }

  public Assert<Tile> tileAt(int x, int y) {
    return new Assert(parent.model.getTile(x, y));
  }

  public Assert<Unit> unitAt(int x, int y) {
    return new Assert(parent.model.getTile(x, y).unit);
  }

  public Assert<Property> propertyAt(int x, int y) {
    return new Assert(parent.model.getTile(x, y).property);
  }

  public Assert<Player> player(int index) {
    return new Assert(parent.model.getPlayer(index));
  }

  public Assert menu() {
    Array<String> menu = JSCollections.$array();
    for (int i = 0; i < parent.uiData.getNumberOfInfos(); i++) {
      menu.push(parent.uiData.getInfoAtIndex(i));
    }
    return new Assert(menu);
  }

  public <X> Assert<X> value(X value) {
    return new Assert(value);
  }
}
