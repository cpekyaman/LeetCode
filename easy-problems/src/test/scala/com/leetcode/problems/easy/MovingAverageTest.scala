package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MovingAverageTest extends FunSuite {

  test("should calculate moving average") {
    // given
    val ma = new MovingAverage(3)

    // when / then
    assert(ma.next(1) == 1.0)
    assert(ma.next(10) == 5.5)
    assert(ma.next(3) == 4.66667)
    assert(ma.next(5) == 6)
  }
}
