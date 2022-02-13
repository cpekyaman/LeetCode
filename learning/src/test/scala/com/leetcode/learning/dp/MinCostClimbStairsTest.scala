package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MinCostClimbStairsTest extends FunSuite {

  test("should find min cost") {
    assert(MinCostClimbStairs.climb(Array(5)) == 5)
    assert(MinCostClimbStairs.climb(Array(3, 7)) == 3)
    assert(MinCostClimbStairs.climb(Array(6, 2)) == 2)
    assert(MinCostClimbStairs.climb(Array(1,3,2,5,6,10,4)) == 13)
  }
}
