package com.leetcode.problems.easy

import org.scalatest.FunSuite

class BinarySubstringsTest extends FunSuite {

  test("should return the count of matching substrings") {
    assert(BinarySubstrings.count("00110011") == 6)
    assert(BinarySubstrings.count("10101") == 4)
    assert(BinarySubstrings.count("000111000") == 6)
  }
}
