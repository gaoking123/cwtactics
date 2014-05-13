/**
 * @class
 */
cwt.Config = my.Class(/** @lends cwt.Config.prototype */ {

  STATIC: /** @lends cwt.Config */ {

    /**
     * Holds all registered configuration parameters.
     *
     * @private
     */
    registeredValues_: {},

    /**
     * Holds all registered configuration parameter names.
     *
     * @private
     * @type {Array.<String>}
     */
    registeredNames_: [],

    /**
     * Registers a configuration parameter.
     *
     * @param {String} name
     * @param {cwt.Config} config
     */
    register_: function (name, config) {
      cwt.assert(!this.registeredValues_.hasOwnProperty(name));
      this.registeredValues_[name] = config;
      this.registeredNames_.push(name);
    },

    /**
     *
     */
    resetAll: function () {
      for (var i = this.registeredNames_.length - 1; i >= 0; i--) {
        var key = this.registeredNames_[i];
        var cfg = this.registeredValues_[key];

        // reset value
        cfg.resetValue();
      }
    },

    /**
     *
     * @param {String} name
     * @param {Number} min
     * @param {Number} max
     * @param {Number} defaultValue
     * @param {Number=} step
     */
    create: function (name, min, max, defaultValue, step) {
      var cfg = new cwt.Config(min, max, defaultValue, step);
      cwt.Config.register_(name, cfg);
    },

    /**
     * Returns the actual configuration value of a given configuration
     * key.
     *
     * @param {String} name
     */
    getValue: function (name) {
      return this.registeredValues_[name].value;
    },

    /**
     * Returns the actual configuration object of a given configuration
     * key.
     *
     * @param {String} name
     */
    getConfig: function (name) {
      return this.registeredValues_[name];
    },

    $onSaveGame: function (data) {
      data.cfg = {};
      for (var i = 0, e = this.registeredNames_.length; i < e; i++) {
        data.cfg[this.registeredNames_[i]] = cwt.Config.getValue(this.registeredNames_[i]);
      }
    },

    $onLoadGame: function (data, isSave) {
      cwt.Config.resetAll();
      if (isSave && data.cfg) {
        for (var i = 0, e = this.registeredNames_.length; i < e; i++) {
          var key = this.registeredNames_[i];
          if (data.cfg[key]) {
            cwt.Config.getConfig(key).setValue(data.cfg[key]);
          }
        }
      }
    }
  },

  /**
   * @param {Number} min
   * @param {Number} max
   * @param {Number} defaultValue
   * @param {Number=} step (default is 1)
   */
  constructor: function (min, max, defaultValue, step) {
    this.min = min;
    this.max = max;
    this.def = defaultValue;
    this.step = (step !== void 0) ? step : 1;
    this.resetValue();
  },

  /**
   *
   * @param {Number} value
   */
  setValue: function (value) {

    // check_ bounds
    if (value < this.min) value = this.min;
    if (value > this.max) value = this.max;

    // check_ steps
    if ((value - this.min) % this.step !== 0) {
      cwt.assert(false, "step criteria is broken");
    }

    this.value = value;
  },

  decreaseValue: function () {
    this.setValue(this.value-this.step);
  },

  increaseValue: function () {
    this.setValue(this.value+this.step);
  },

  /**
   * Resets the value of the parameter back to the default
   * value.
   */
  resetValue: function () {
    this.value = this.def;
  }

});