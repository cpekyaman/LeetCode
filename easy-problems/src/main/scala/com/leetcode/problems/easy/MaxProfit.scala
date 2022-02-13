package com.leetcode.problems.easy

object MaxProfit {
  def calculate(prices: Array[Int]): Int = {
    if(prices.length == 1) {
      return 0
    }

    var profit = 0

    var lo = 0
    for(hi <- 1 until prices.length) {
      val current = prices(hi) - prices(lo)
      if(current >= 0) {
        profit = Integer.max(profit, current)
      } else {
        lo = hi
      }
    }

    profit
  }
}
