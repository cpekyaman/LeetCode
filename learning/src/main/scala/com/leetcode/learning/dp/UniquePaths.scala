package com.leetcode.learning.dp

object UniquePaths {
  def find(m: Int, n: Int): Int = {
    bottomUp(m, n)
    topDown(m, n)
  }

  private def bottomUp(m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m, n)

    dp(0)(0) = 1

    for(r <- 0 until m) {
      for(c <- 0 until n) {
        dp(r)(c) += (if(r > 0) dp(r - 1)(c) else 0)
        dp(r)(c) += (if(c > 0) dp(r)(c - 1) else 0)
      }
    }

    dp(m-1)(n-1)
  }

  private def topDown(m: Int, n: Int): Int = {
    val mem = Array.ofDim[Int](m,n)
    topDown(m - 1, n - 1, mem)
  }

  private def topDown(r: Int, c: Int, mem: Array[Array[Int]]): Int = {
    if(r == 0 && c == 0) {
      return 1
    }

    if(mem(r)(c) == 0) {
      var ans = if(r > 0) topDown(r - 1, c, mem) else 0
      ans += (if(c > 0) topDown(r, c - 1, mem) else 0)

      mem(r)(c) = ans
    }

    mem(r)(c)
  }
}