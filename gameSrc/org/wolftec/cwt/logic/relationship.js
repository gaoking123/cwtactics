
// Means two objects are the same object (so there is only one object).
//
exports.RELATION_SAME_THING = -1;

// Means there is no relationship between two objects.
//
exports.RELATION_NEUTRAL = 0;

// Means two objects belongs to the same owner.
//
exports.RELATION_OWN = 1;

// Means two objects belongs to the same team.
//
exports.RELATION_ALLIED = 2;

// Means two objects belongs not to the same owner (they are enemies).
//
exports.RELATION_ENEMY = 3;

// Means at least one of the two arguments is null.
//
exports.RELATION_NONE = 4;

// Indicates a wish to check in the hierarchical way. First try to extract the unit owner and then the property
// owner when no unit exists.
//
exports.CHECK_NORMAL = 0;

// Indicates a wish to check unit owner.
//
exports.CHECK_UNIT = 1;

// Indicates a wish to check property owner.
//
exports.CHECK_PROPERTY = 2;

//
// Extracts the relationship between the object **left** and the object **right** and returns the correct
// **RELATION_{?}** constant. The check mode can be set by **checkLeft** and **checkRight**.
//
exports.getRelationShipTo = function (left, right, checkLeft, checkRight) {
  var oL;
  var oR;

  if (checkLeft !== exports.CHECK_PROPERTY) oL = left.unit;
  if (checkRight !== exports.CHECK_PROPERTY) oR = right.unit;

  if (!oL && checkLeft !== exports.CHECK_UNIT) oL = left.property;
  if (!oR && checkRight !== exports.CHECK_UNIT) oR = right.property;

  if (!oL) {
    return exports.RELATION_NULL;
  }

  return exports.getRelationship(oL, oR);
};

//
// Extracts the relationship between **objectA** and **objectB** and returns the correct **RELATION_{?}** constant.
//
exports.getRelationship = function (objectA, objectB) {

  // one object is null
  if (objectA === null || objectB === null) {
    return exports.RELATION_NONE;
  }

  // same object
  if (objectA === objectB) {
    return exports.RELATION_SAME_THING;
  }

  var playerA = (objectA instanceof model.Player) ? objectA : objectA.owner;
  var playerB = (objectB instanceof model.Player) ? objectB : objectB.owner;

  // one of the owners is inactive or not set (e.g. neutral properties)
  if (playerA === null || playerB === null || playerA.team === -1 || playerB.team === -1) {
    return exports.RELATION_NEUTRAL;
  }

  // same side
  if (playerA === playerB) {
    return exports.RELATION_OWN;
  }

  // allied or enemy ?
  if (playerA.team === playerB.team) {
    return exports.RELATION_ALLIED;
  } else {
    return exports.RELATION_ENEMY;
  }
};

//
// Returns **true **if there is at least one unit with a given **relationship** to **player** in one of the
// neighbours of a given position (**x**,**y**). If not, **false** will be returned.
//
exports.hasUnitNeighbourWithRelationship = function (player, x, y, relationship) {
  if (constants.DEBUG) assert(model.isValidPosition(x, y));

  var unit;

  // WEST
  if (x > 0) {
    unit = model.mapData[x - 1][y].unit;
    if (unit && exports.getRelationship(player, unit.owner) === relationship) return true;
  }

  // NORTH
  if (y > 0) {
    unit = model.mapData[x][y - 1].unit;
    if (unit && exports.getRelationship(player, unit.owner) === relationship) return true;
  }

  // EAST
  if (x < model.mapWidth - 1) {
    unit = model.mapData[x + 1][y].unit;
    if (unit && exports.getRelationship(player, unit.owner) === relationship) return true;
  }

  // SOUTH
  if (y < model.mapHeight - 1) {
    unit = model.mapData[x][y + 1].unit;
    if (unit && exports.getRelationship(player, unit.owner) === relationship) return true;
  }

  return false;
};