package com.leetcode.learning.dp

object MaxStockProfitV4 {
  def solve(prices: Array[Int], k: Int): Int = {
    topDown(prices, k)
    bottomUp(prices, k)
  }

  private def bottomUp(prices: Array[Int], k: Int): Int = {
    val n = prices.length
    val dp = Array.ofDim[Int](n+1, k+1, 2)

    for(i <- n-1 to 0 by -1) {
      for(t <- 1 to k) {
        for(h <- 0 to 1) {
          val doNothing = dp(i+1)(t)(h)
          dp(i)(t)(h) = if(h == 1) {
            // do nothing or sell at i
            Integer.max(doNothing, prices(i) + dp(i + 1)(t - 1)(0))
          } else {
            // do nothing or but at i
            Integer.max(doNothing, -prices(i) + dp(i + 1)(t)(1))
          }
        }
      }
    }

    dp(0)(k)(0)
  }

  private def topDown(prices: Array[Int], k: Int): Int = {
    val mem = Array.ofDim[Int](prices.length, k+1, 2)
    topDown(prices, k, 0, 0, k, mem)
  }

  private def topDown(prices: Array[Int], k: Int,
                      holding: Int, i: Int, remaining: Int,
                      mem: Array[Array[Array[Int]]]): Int = {

    if(i == prices.length || remaining == 0) {
      return 0
    }

    if(mem(i)(remaining)(holding) != 0) {
      return mem(i)(remaining)(holding)
    }

    val doNothing = topDown(prices, k, holding, i + 1, remaining, mem)
    mem(i)(remaining)(holding) = if(holding == 1) {
      val sell = prices(i) + topDown(prices, k, 0, i + 1, remaining - 1, mem)
      Integer.max(sell, doNothing)
    } else {
      val buy = -prices(i) + topDown(prices, k, 1, i + 1, remaining, mem)
      Integer.max(buy, doNothing)
    }

    mem(i)(remaining)(holding)
  }
}
