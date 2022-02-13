package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MaxProfitTest extends FunSuite {

  test("no profit for single element array") {
    assert(MaxProfit.calculate(Array(5)) == 0)
  }

  test("no profit when no high sell price found") {
    assert(MaxProfit.calculate(Array(8, 7, 6, 5, 4, 2)) == 0)
  }

  test("should find max profit when prices are correct") {
    assert(MaxProfit.calculate(Array(3, 7)) == 4)
    assert(MaxProfit.calculate(Array(9, 4)) == 0)
    assert(MaxProfit.calculate(Array(8, 9, 6, 5, 4, 2)) == 1)
    assert(MaxProfit.calculate(Array(5, 7, 4, 8, 3, 6)) == 4)
    assert(MaxProfit.calculate(Array(7, 1, 5, 3, 6, 4)) == 5)
    assert(MaxProfit.calculate(Array(2, 9, 4, 8, 3, 6)) == 7)
    assert(MaxProfit.calculate(Array(6, 7, 12, 3, 8, 6, 4, 5)) == 6)
  }
}
