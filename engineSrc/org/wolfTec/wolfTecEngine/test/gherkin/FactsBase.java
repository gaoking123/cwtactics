package org.wolfTec.wolfTecEngine.test.gherkin;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.RegExp;
import org.stjs.javascript.functions.Callback1;
import org.wolfTec.wolfTecEngine.components.JsUtil;

public class FactsBase {

  private Array<RegExp> givenSentences;
  private Array<RegExp> whenSentences;
  private Array<RegExp> thenSentences;

  private Array<Callback1<Array<String>>> givenHandlers;
  private Array<Callback1<Array<String>>> whenHandlers;
  private Array<Callback1<Array<String>>> thenHandlers;

  public FactsBase() {
    givenSentences = JSCollections.$array();
    whenSentences = JSCollections.$array();
    thenSentences = JSCollections.$array();
    givenHandlers = JSCollections.$array();
    whenHandlers = JSCollections.$array();
    thenHandlers = JSCollections.$array();
  }

  public void addGiven(RegExp regExp, Callback1<Array<String>> handler) {
    addFact(givenSentences, regExp, givenHandlers, handler);
  }

  public void addWhen(RegExp regExp, Callback1<Array<String>> handler) {
    addFact(whenSentences, regExp, whenHandlers, handler);
  }

  public void addThen(RegExp regExp, Callback1<Array<String>> handler) {
    addFact(thenSentences, regExp, thenHandlers, handler);
  }

  @SuppressWarnings("unchecked")
  public void addFact(Array<RegExp> regExpList, RegExp regExp,
      Array<Callback1<Array<String>>> handlerList, Callback1<Array<String>> handler) {

    if (regExp == null || handler == null) {
      JsUtil.raiseError("IllegalArgumentException");
    }

    regExpList.push(regExp);
    handlerList.push(handler);
  }
}
