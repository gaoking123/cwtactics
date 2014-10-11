"use strict";

var constants = require("./constants");
var workflow = require("./system/async");
var storage = require("./storage");
var debug = require("./debug");

var PARAM_HAS_CACHE = "__hasCache__";

var hasCachedData = false;

/**
 * Starts the loading process. After the loading process the loading stuff will be removed.
 * The Loading namespace will remain with a property with value true as marker. This
 * property will be named deInitialized.
 *
 * @param setProcess
 * @param callback
 */
exports.startProcess = function (setProcess, callback) {
  function setProgress(i) {
    return function (next) {
      setProcess(i);
      next();
    };
  }

  function setLoader(mod) {
    return function (next) {
      mod.loader(next, hasCachedData);
    };
  }

  debug.logInfo("start loading game data");
  storage.get(PARAM_HAS_CACHE, function (value) {
    hasCachedData = value;
    workflow.sequence([
        setLoader(require("./loading/checkSystem")),
        setProgress(5),
        setLoader(require("./loading/startParameters")),
        setProgress(10),
        setLoader(require("./loading/loadMod")),
        setProgress(15),
        setLoader(require("./loading/injectMod")),
        setProgress(20),
        setLoader(require("./loading/language")),
        setProgress(25),
        setLoader(require("./loading/imageLoad")),
        setProgress(50),
        setLoader(require("./loading/audioInit")),
        setProgress(75),
        setLoader(require("./loading/inputInit")),
        setProgress(80),
        setLoader(require("./loading/loadMaps")),
        setProgress(90),
        setLoader(require("./loading/portraitCheck")),
        setProgress(95),
        setLoader(require("./loading/addStates")),
        setProgress(100),
        function (next){
          // release cached modification
          require("./dataTransfer/mod").clearCachedMod();
          next();
        }
      ],
      function () {
        if (callback) {
          debug.logInfo("finished loading game data");
          storage.set(PARAM_HAS_CACHE, true, callback);
        }
      }
    );
  });
};