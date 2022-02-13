package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MaxSubArrayTest extends FunSuite {

  test("single element is the result for one element array") {
    assert(MaxSubArray.find(Array(5)) == 5)
    assert(MaxSubArray.find(Array(3)) == 3)
  }

  test("should return max negative item when all are negative") {
    assert(MaxSubArray.find(Array(-3, -6, -8, -5, -7)) == -3)
  }

  test("should return the max contiguous sum") {
    assert(MaxSubArray.find(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) == 6)
  }
}
