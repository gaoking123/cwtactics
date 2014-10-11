"use strict";

var constants = require("./constants");

// Id of the game in the connected network session.
var gameId = null;

// Id of the client in the connected network session.
var clientId = constants.INACTIVE;

/**
 * @return {Boolean}
 */
exports.isActive = function() {
	return gameId !== null;
};

/**
 * @return {Boolean}
 */
exports.isHost = function() {
	return gameId === null || clientId !== constants.INACTIVE;
};

/**
 * Parses a message and invokes commands if necessary.
 */
exports.parseMessage = function(msg) {
	throw new Error("NotImplementedYetException");
};

/**
 * Sends a given action data object into data object and sends it to the game server.
 */
exports.sendMessage = function(actionData) {
  throw new Error("NotImplementedYetException");
};

//var targetURL = null;
//var urlBuilderHelper = [ null, "?cmd=", null, "&gameId=", null, "&userId=", null ];
//var parserHelper = function () {
//  if (this.readyState === 4) {
//    var res = this.responseText;
//    if (res !== "") {
//      var data = res.split("_&_");
//      for (var i = 0, e = data.length; i < e; i++) {
//
//        if (data[i] !== undefined && data[i].length > 0) {
//          parseMessage(data[i]);
//        }
//      }
//    }
//  }
//};
//var createRequest = function () {
//  var xmlHttp = new XMLHttpRequest();
//
//  // generate URL
//  urlBuilderHelper[0] = this.targetURL;
//  urlBuilderHelper[2] = "GRABCMD";
//  urlBuilderHelper[4] = this.gameId;
//  urlBuilderHelper[6] = this.clientId;
//
//  xmlHttp.open('GET', urlBuilderHelper.join(""), true);
//  xmlHttp.onreadystatechange = parserHelper;
//  xmlHttp.send(null);
//};