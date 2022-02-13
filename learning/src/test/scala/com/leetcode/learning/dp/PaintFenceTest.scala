package com.leetcode.learning.dp

import org.scalatest.FunSuite

class PaintFenceTest extends FunSuite {

  test("should determine ways to paint fence") {
    assert(PaintFence.solve(3, 2) == 6)
    assert(PaintFence.solve(1, 1) == 1)
    assert(PaintFence.solve(7, 2) == 42)
  }
}
