package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class ReverseStringTest extends FunSuite {
  test("should reverse the string given as array") {
    assert(ReverseString.reverse(Array('H', 'e', 'l', 'l', 'o')).sameElements(Array('o', 'l', 'l', 'e', 'H')))
  }

}
