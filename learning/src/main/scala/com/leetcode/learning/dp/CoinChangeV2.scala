package com.leetcode.learning.dp

object CoinChangeV2 {

  def solve(coins: Array[Int], amount: Int): Int = {
    bottomUp(coins, amount)
  }

  private def bottomUp(coins: Array[Int], amount: Int): Int = {
    if(amount == 0) {
      return 1
    }

    if(coins.length == 0) {
      return 0
    }

    val dp = Array.ofDim[Int](amount + 1)

    // if amount is zero take zero coins
    dp(0) = 1

    for(c <- coins) {
      for(a <- c to amount) {
        dp(a) += dp(a - c)
      }
    }

    dp(amount)
  }
}
