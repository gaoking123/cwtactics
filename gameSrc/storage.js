/*jslint node: true, plusplus: true, vars: true */
"use strict";

/**
 * iOS 7 has a serious bug which makes unable to get the permission to increase the internal 
 * persistent storage above 5MB. To prevent that bug we simply use 4 MB as storage. If the 
 * pre-set size of the storage is below 5MB then iOS7 creates a database that can be filled 
 * up to 50MB without any permission. Strange? Yes it is! 
 * 
 * @constant
 */
var IOS7_WEBSQL_BUGFIX_SIZE = 4;

/**
 * Maximum size of the application stoarge.
 * 
 * @constant
 */
var DEFAULT_DB_SIZE = 50;

// TODO: include common js prepared version of localforage
var localforage = window.localforage;

// configures the localforage library
localforage.config({
  name: "CWT_DATABASE",
  size: (require("./system/features").iosWebSQLFix ?
         IOS7_WEBSQL_BUGFIX_SIZE : DEFAULT_DB_SIZE) * 1024 * 1024
});

/**
 * The given callback will be invoked with the value saved by the given key.
 */
exports.get = function (key, callback) {
  localforage.getItem(key, callback);
};

/**
 * Saves a value with a given key. If the key exists, then the old value 
 * will be overwritten. After the save process, the callback will be invoked.
 */
exports.set = function (key, value, callback) {
  localforage.setItem(key, value, function (res, error) {

    // try a second time when fail at the first time because on ios the question
    // for more storage invokes an error => we don't want to need to reload then
    if (error) {
      localforage.setItem(key, value, callback);
    } else {
      callback(res);
    }
  });
};

/**
 * The given callback will be invoked with a list of all keys that are saved in the storage.
 */
exports.keys = function (callback) {
  localforage.keys(callback);
};

/**
 * Clears all values from the storage. The given callback will be invoked afterwards.
 */
exports.clear = function (callback) {
  localforage.clear(callback);
};

/**
 * Removes a key including the saved value from the storage. The given callback will 
 * be invoked afterwards.
 */
exports.remove = function (key, callback) {
  localforage.removeItem(key, callback);
};