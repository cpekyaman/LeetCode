package com.leetcode.problems.easy

import org.scalatest.FunSuite

class LongestCommonPrefixTest extends FunSuite {

  test("should return empty string for empty array") {
    assert(LongestCommonPrefix.find(Array.empty[String]).isEmpty)
  }

  test("should return the sole element for single element array") {
    assert(LongestCommonPrefix.find(Array("single")) == "single")
  }

  test("should return common prefix") {
    assert(LongestCommonPrefix.find(Array("flower", "flow", "flight")) == "fl")
    assert(LongestCommonPrefix.find(Array("dog", "racecar", "car")).isEmpty)
    assert(LongestCommonPrefix.find(Array("jackson", "jacobien", "jack", "jacque")) == "jac")
  }
}
