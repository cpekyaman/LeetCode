package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class LargestRectangleInHistogramTest extends FunSuite {

  test("should find max area rectangle") {
    assert(LargestRectangleInHistogram.find(Array(6,4,5,2,4,3,9)) == 14)
  }
}
