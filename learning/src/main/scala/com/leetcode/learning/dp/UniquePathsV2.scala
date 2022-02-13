package com.leetcode.learning.dp

object UniquePathsV2 {
  def find(grid: Array[Array[Int]]): Int = {
    bottomUp(grid)
  }

  private def bottomUp(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val dp = Array.ofDim[Int](m, n)

    dp(0)(0) = 1

    for(r <- 0 until m) {
      for(c <- 0 until n) {
        if(grid(r)(c) == 1) {
          dp(r)(c) = 0
        } else {
          dp(r)(c) += (if(r > 0) dp(r - 1)(c) else 0)
          dp(r)(c) += (if(c > 0) dp(r)(c - 1) else 0)
        }
      }
    }

    dp(m-1)(n-1)
  }
}
