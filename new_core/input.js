import { mapping } from "./config/input.js"
import { input as actionStatusMap } from "./state.js"

const actionStatusCounterMap = {}
const keyStatusCounterMap = {}

function evaluateKeyEvent(keyStatusModifier, event) {
  const eventKey = event.code
  const newKeyStatus = keyStatusModifier === 1 ? true : false

  if (keyStatusCounterMap[eventKey] === newKeyStatus) {
    return
  }

  const eventAction = mapping.keyboard[eventKey]

  if (!eventAction) {
    return
  }

  const currentCounter = actionStatusCounterMap[eventAction] || 0
  const newCounter = currentCounter + keyStatusModifier
  
  if (newCounter < 0) {
    throw new Error("illegal state, action status counter is below 0")
  }

  keyStatusCounterMap[eventKey] = newKeyStatus
  actionStatusCounterMap[eventAction] = newCounter

  event.preventDefault();
}

document.onkeydown = evaluateKeyEvent.bind(null, +1)
document.onkeyup = evaluateKeyEvent.bind(null, -1)

function updateActionStatus(keyId, counterStatus) {
  const currentStatus = actionStatusMap[keyId] 

  if (currentStatus !== counterStatus) {
    console.log("changed key status,", keyId, "is now", (counterStatus ? "PRESSED" : "RELEASED"))
    actionStatusMap[keyId] = counterStatus
  }
} 

export function setup () {
 
  Object.keys(actionStatusCounterMap).forEach(key => actionStatusCounterMap[key] = 0)

  Object.keys(actionStatusCounterMap).forEach(key => {
    if (key.includes("ShiftLeft") || key.includes("ShiftRight")) {
      throw new Error("Shift key is not supported right now")
    }
  })
}

export function update() {  
  updateActionStatus("DEBUG_A", actionStatusCounterMap["DEBUG_A"] > 0)
  updateActionStatus("DEBUG_B", actionStatusCounterMap["DEBUG_B"] > 0)
  updateActionStatus("DOWN", actionStatusCounterMap["DOWN"] > 0)
  updateActionStatus("UP", actionStatusCounterMap["UP"] > 0)
  updateActionStatus("RIGHT", actionStatusCounterMap["RIGHT"] > 0)
  updateActionStatus("LEFT", actionStatusCounterMap["LEFT"] > 0)
  updateActionStatus("ACTION", actionStatusCounterMap["ACTION"] > 0)
  updateActionStatus("CANCEL", actionStatusCounterMap["CANCEL"] > 0)
}