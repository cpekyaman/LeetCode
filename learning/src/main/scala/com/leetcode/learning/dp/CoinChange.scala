package com.leetcode.learning.dp

object CoinChange {

  def solve(coins: Array[Int], amount: Int): Int = {
    topDown(coins, amount, Array.ofDim[Int](amount + 1))
  }

  private def bottomUp(coins: Array[Int], amount: Int): Int = {
    val max = amount + 1
    val dp = Array.fill[Int](amount + 1)(max)

    dp(0) = 0

    for(a <- 1 to amount) {
      for(c <- coins) {
        if(a >= c) {
          dp(a) = Integer.min(dp(a), dp(a-c) + 1)
        }
      }
    }

    if(dp(amount) < max) dp(amount) else -1
  }

  private def topDown(coins: Array[Int], amount: Int, count: Array[Int]): Int = {
    if(amount < 0) {
      return -1
    }
    if(amount == 0) {
      return 0
    }

    if(count(amount) != 0) {
      return count(amount)
    }

    var min = Int.MaxValue
    // for each coin we have
    for(c <- coins) {
      // find a viable solution for after we pick the coin
      // and pick the min number of coins
      val res = topDown(coins, amount - c, count)
      if(res >= 0) {
        // adding 1 to represent adding current coin to set of coins
        min = Integer.min(min, res + 1)
      }
    }
    // this is the min num of coins to reach this amount
    count(amount) = if (min == Int.MaxValue) -1 else min

    count(amount)
  }
}
