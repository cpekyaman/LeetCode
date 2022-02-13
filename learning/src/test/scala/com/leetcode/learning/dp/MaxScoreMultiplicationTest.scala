package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MaxScoreMultiplicationTest extends FunSuite {

  test("topDown should calculate max") {
    assert(MaxScoreMultiplication.topDown(Array(1,2,3), Array(3,2,1)) == 14)
    assert(MaxScoreMultiplication.topDown(Array(-5,-3,-3,-2,7,1), Array(-10,-5,3,4,6)) == 102)
  }

  test("bottomUp should calculate max") {
    assert(MaxScoreMultiplication.bottomUp(Array(1,2,3), Array(3,2,1)) == 14)
    assert(MaxScoreMultiplication.bottomUp(Array(-5,-3,-3,-2,7,1), Array(-10,-5,3,4,6)) == 102)
  }
}
