package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class ClimbingStairsTest extends FunSuite {

  test("should return base conditions properly") {
    assert(ClimbingStairs.climbStairs(1) == 1)
    assert(ClimbingStairs.climbStairs(2) == 2)
    assert(ClimbingStairs.climbStairs(3) == 3)
  }
}
