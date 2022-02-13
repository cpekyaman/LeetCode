package com.leetcode.learning.dp

object MinimumPathSum {

  def find(grid: Array[Array[Int]]): Int = {
    topDown(grid)
    bottomUp(grid)
  }

  private def bottomUp(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val dp = Array.ofDim[Int](m,n)

    dp(0)(0) = grid(0)(0)

    for(r <- 0 until m) {
      for(c <- 0 until n) {
        // our cost is cell value + one of four possible from cells
        dp(r)(c) = grid(r)(c) + (if(r > 0 && c > 0) {
           Integer.min(dp(r-1)(c), dp(r)(c-1))
        } else if(r > 0) {
          dp(r-1)(c)
        } else if(c > 0) {
          dp(r)(c-1)
        } else {
          0
        })
      }
    }

    dp(m-1)(n-1)
  }

  private def topDown(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val mem = Array.ofDim[Int](m,n)
    topDown(grid, m - 1, n - 1, mem)
  }

  private def topDown(grid: Array[Array[Int]], r: Int, c: Int, mem: Array[Array[Int]]): Int = {
    if(r == 0 && c == 0) {
      return grid(r)(c)
    }

    if(mem(r)(c) == 0) {
      val top = if(r > 0) topDown(grid, r - 1, c, mem) else Integer.MAX_VALUE
      val left = if(c > 0) topDown(grid, r, c - 1, mem) else Integer.MAX_VALUE

      mem(r)(c) = grid(r)(c) + Integer.min(top, left)
    }

    mem(r)(c)
  }
}
