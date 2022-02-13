package com.leetcode.learning.dp

object MaxStockProfitWithCooldown {

  def solve(prices: Array[Int]): Int = {
    topDown(prices)
    bottomUp(prices)
  }

  private def bottomUp(prices: Array[Int]): Int = {
    val n = prices.length
    val dp = Array.ofDim[Int](n + 1, 2, 2)

    for(i <- n-1 to 0 by -1) {
      for(h <- 0 to 1) {
        for(c <- 0 to 1) {
          // doNothing always resets cooldown as a day passes
          val doNothing = dp(i+1)(h)(0)
          dp(i)(h)(c) = if(c == 1) {
            // we don't have any other option
            doNothing
          } else {
            val action = if(h == 1) {
              // selling and entering cooldown
              prices(i) + dp(i+1)(0)(1)
            } else {
              // buying and entering holding
              -prices(i) + dp(i+1)(1)(0)
            }
            Integer.max(doNothing, action)
          }
        }
      }
    }

    dp(0)(0)(0)
  }

  private def topDown(prices: Array[Int]): Int = {
    val mem = Array.ofDim[Int](prices.length, 2, 2)
    topDown(prices, 0, 0, 0, mem)
  }

  private def topDown(prices: Array[Int], i: Int, holding: Int, cooldown: Int,
                      mem: Array[Array[Array[Int]]]): Int = {

    if(i == prices.length) {
      return 0
    }

    if(mem(i)(holding)(cooldown) == 0) {
      val doNothing = topDown(prices, i + 1, holding, 0, mem)
      mem(i)(holding)(cooldown) = if(holding == 1) {
        val sell = prices(i) + topDown(prices, i + 1, 0, 1, mem)
        Integer.max(doNothing, sell)
      } else if(cooldown == 1) {
        doNothing
      } else {
        val buy = -prices(i) + topDown(prices, i + 1, 1, 0, mem)
        Integer.max(doNothing, buy)
      }
    }

    mem(i)(holding)(cooldown)
  }
}
