package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ReorderLogDataTest extends FunSuite {

  test("should sort log data correctly") {
    // given
    val strings = Array("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")

    // when / then
    assert(ReorderLogData.reorder(strings).sameElements(Array("let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6")))
  }
}
