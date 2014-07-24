//
// Modifies a vision at a given position and player id.
//
exports.modifyVision_ = function (x, y, owner, range, value) {

  // ignore neutral objects
  if (owner.team === cwt.INACTIVE) return;

  if (cwt.Config.getValue("fogEnabled") !== 1) return;

  var clientVisible = owner.clientVisible;
  var turnOwnerVisible = owner.turnOwnerVisible;

  // no active player owns this vision
  if (!clientVisible && !turnOwnerVisible) return;

  var map = cwt.Model.mapData;
  if (range === 0) {
    if (clientVisible) map[x][y].visionClient += value;
    if (turnOwnerVisible) map[x][y].visionTurnOwner += value;

  } else {
    var mW = cwt.Model.mapWidth;
    var mH = cwt.Model.mapHeight;
    var lX;
    var hX;
    var lY = y - range;
    var hY = y + range;

    if (lY < 0) lY = 0;
    if (hY >= mH) hY = mH - 1;
    for (; lY <= hY; lY++) {

      var disY = Math.abs(lY - y);
      lX = x - range + disY;
      hX = x + range - disY;
      if (lX < 0) lX = 0;
      if (hX >= mW) hX = mW - 1;
      for (; lX <= hX; lX++) {

        // does the tile block vision ?
        if (map[lX][lY].type.blocksVision && cwt.Model.getDistance(x, y, lX, lY) > 1) continue;

        if (clientVisible) map[lX][lY].visionClient += value;
        if (turnOwnerVisible) map[lX][lY].visionTurnOwner += value;
      }
    }
  }
};

//
// Completely recalculates the fog aw2.
//
exports.fullRecalculation = function () {
  var x;
  var y;
  var xe = cwt.Model.mapWidth;
  var ye = cwt.Model.mapHeight;
  var fogEnabled = (cwt.Config.getValue("fogEnabled") === 1);
  var map = cwt.Model.mapData;

  // 1. reset fog maps
  for (x = 0; x < xe; x++) {
    for (y = 0; y < ye; y++) {

      if (!fogEnabled) {
        map[x][y].visionTurnOwner = 1;
        map[x][y].visionClient = 1;
      } else {
        map[x][y].visionTurnOwner = 0;
        map[x][y].visionClient = 0;
      }
    }
  }

  // 2. add vision-object
  if (fogEnabled) {
    var vision;
    var unit;
    var tile;
    var property;

    for (x = 0; x < xe; x++) {
      for (y = 0; y < ye; y++) {
        tile = map[x][y];

        unit = tile.unit;
        if (unit !== null) {
          vision = unit.type.vision;
          if (vision < 0) vision = 0;

          this.modifyVision_(x, y, unit.owner, vision, 1);
        }

        property = tile.property;
        if (property !== null && property.owner !== null) {
          vision = property.type.vision;
          if (vision < 0) vision = 0;

          this.modifyVision_(x, y, property.owner, vision, 1);
        }
      }
    }
  }
};

//
// Removes a vision-object from the fog map.
//
exports.removeVision = function (x, y, owner, range) {
  this.modifyVision_(x, y, owner, range, -1);
};

exports.removeUnitVision = function (x, y, owner) {
  var unit = cwt.Model.mapData[x][y].unit;
  if (!owner) owner = unit.owner;

  this.removeVision(x, y, owner, unit.type.vision);
};

exports.removePropertyVision = function (x, y, owner) {
  var prop = cwt.Model.mapData[x][y].property;
  if (!owner) owner = prop.owner;

  this.removeVision(x, y, owner, prop.type.vision);
};

//
// Adds a vision-object from the fog map.
//
exports.addVision = function (x, y, owner, range) {
  this.modifyVision_(x, y, owner, range, +1);
};

exports.addUnitVision = function (x, y, owner) {
  var unit = cwt.Model.mapData[x][y].unit;
  if (!owner) owner = unit.owner;

  this.addVision(x, y, owner, unit.type.vision);
};

exports.addPropertyVision = function (x, y, owner) {
  var prop = cwt.Model.mapData[x][y].property;
  if (!owner) owner = prop.owner;

  this.addVision(x, y, owner, prop.type.vision);
};

/*
 model.event_on("modifyVisionAt", function( x,y, pid, range, value ){
 range = 10; // TAKE THE MAXIMUM RANGE

 var lX;
 var hX;
 var lY = y-range;
 var hY = y+range;
 if( lY < 0 ) lY = 0;
 if( hY >= model.map_height ) hY = model.map_height-1;
 for( ; lY<=hY; lY++ ){

 var disY = Math.abs( lY-y );
 lX = x-range+disY;
 hX = x+range-disY;
 if( lX < 0 ) lX = 0;
 if( hX >= model.map_width ) hX = model.map_width-1;
 for( ; lX<=hX; lX++ ){
 view.redraw_markPos( lX,lY );

 var unit = model.unit_posData[lX][lY];
 if( unit !== null && unit.hidden ){
 controller.updateUnitStatus( model.unit_extractId( unit ) );
 }
 }
 }
 });

 model.event_on("recalculateFogMap",function(range){
 view.redraw_markAll();
 });
 //*/
