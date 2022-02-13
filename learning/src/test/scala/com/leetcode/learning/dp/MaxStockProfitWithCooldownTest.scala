package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MaxStockProfitWithCooldownTest extends FunSuite {

  test("should find max profit with cooldown") {
    assert(MaxStockProfitWithCooldown.solve(Array(1,2,3,0,2)) == 3)
    assert(MaxStockProfitWithCooldown.solve(Array(1)) == 0)
  }
}
