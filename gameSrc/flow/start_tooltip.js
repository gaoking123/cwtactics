cwt.Gameflow.addState({
  id: "START_SCREEN",

  init: function () {
    this.TOOLTIP_TIME = 10000;
    this.tooltip_time = this.TOOLTIP_TIME;

    /**
     * @type {HTMLCanvasElement|HTMLImageElement|null}
     */
    this.background = null;

    this.tooltip = new cwt.uiGameButton(
      parseInt(cwt.Screen.width*0.1, 10),
      parseInt(cwt.Screen.height*0.2, 10),
      parseInt(cwt.Screen.width*0.8, 10),
      40,
      "",
      10
    );

    this.button = new cwt.uiGameButton(
      parseInt(cwt.Screen.width*0.5 - 150, 10),
      parseInt(cwt.Screen.height*0.8, 10) - 20,
      300,
      40,
      "START",
      20
    );
  },

  enter: function () {
    cwt.Screen.layerUI.clear();

    var numBackgrounds = cwt.Image.sprites.BACKGROUNDS.getNumberOfImages();
    var randBGIndex = parseInt(Math.random()*numBackgrounds,10);

    this.background = cwt.Image.sprites.BACKGROUNDS.getImage(randBGIndex);
  },

  update: function (delta, lastInput) {

    // action leads into main menu
    if (lastInput && lastInput.key === cwt.Input.TYPE_ACTION) {
      cwt.Gameflow.changeState("MAIN_MENU");

    } else {
      this.tooltip_time += delta;
      if (this.tooltip_time >= this.TOOLTIP_TIME) {

        // update random tooltip
        var randEl = cwt.Tooltips[parseInt( Math.random()*cwt.Tooltips.length, 10)];
        this.tooltip.text = cwt.Localization.forKey(randEl);

        this.tooltip_time = 0;
      }
    }
  },

  render: function () {
    if (this.background) {
      cwt.Screen.layerBG.getContext().drawImage(
        this.background,
        0, 0,
        cwt.Screen.width,
        cwt.Screen.height
      );

      this.background = null;
    }

    this.button.draw(cwt.Screen.layerUI.getContext());
    this.tooltip.draw(cwt.Screen.layerUI.getContext());
  }
});