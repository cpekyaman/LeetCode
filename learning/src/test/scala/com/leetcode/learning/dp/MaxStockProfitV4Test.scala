package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MaxStockProfitV4Test extends FunSuite {

  test("should find max profit with k transactions") {
    assert(MaxStockProfitV4.solve(Array(3), 2) == 0)
    assert(MaxStockProfitV4.solve(Array(1,3,4), 0) == 0)
    assert(MaxStockProfitV4.solve(Array(1,4), 1) == 3)
    assert(MaxStockProfitV4.solve(Array(2,4,1), 2) == 2)
    assert(MaxStockProfitV4.solve(Array(3,2,6,5,0,3), 2) == 7)
  }
}
