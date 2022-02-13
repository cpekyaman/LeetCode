package com.leetcode.learning.dp

import org.scalatest.FunSuite

class WordBreakTest extends FunSuite {

  test("should determine if the string is composable") {
    assert(WordBreak.solve("leetcode", List("leet", "code")))
    assert(WordBreak.solve("applepenapple", List("apple", "pen")))
    assert(! WordBreak.solve("catsandog", List("cats", "dog", "sand", "and", "cat")))
  }
}
