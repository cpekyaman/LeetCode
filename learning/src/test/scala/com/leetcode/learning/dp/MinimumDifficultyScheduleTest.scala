package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MinimumDifficultyScheduleTest extends FunSuite {

  test("should find minimum difficulty schedule") {
    assert(MinimumDifficultySchedule.solve(Array(6,5,4,3,2,1), 2) == 7)
    assert(MinimumDifficultySchedule.solve(Array(9,9,9), 4) == -1)
    assert(MinimumDifficultySchedule.solve(Array(1,1,1), 3) == 3)
  }
}
