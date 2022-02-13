package com.leetcode.learning.dp

object MinFallingPathSum {
  def find(matrix: Array[Array[Int]]): Int = {
    topDown(matrix)
  }

  //TODO: fix
  private def bottomUp(matrix: Array[Array[Int]]): Int = {
    val m = matrix.length
    val n = matrix(0).length

    val dp = Array.fill[Int](m,n+2) { Integer.MAX_VALUE }
    for(c <- 0 until n) {
      dp(m-1)(c) = matrix(m-1)(c)
    }

    for(r <- m-2 to 0 by -1) {
      for(c <- 1 to n) {
        dp(r)(c) = matrix(r)(c-1) + Integer.min(Integer.min(dp(r+1)(c-1), dp(r+1)(c)), dp(r+1)(c+1))
      }
    }

    var min = Integer.MAX_VALUE
    for(c <- 1 to n) {
      min = Integer.min(min, dp(0)(c))
    }
    min
  }

  private def topDown(matrix: Array[Array[Int]]): Int = {
    val m = matrix.length
    val n = matrix(0).length

    val mem = Array.ofDim[Int](m,n)
    var min = Integer.MAX_VALUE
    for(c <- 0 until n) {
      val current = topDown(matrix, 0, c, mem)
      min = Integer.min(min, current)
    }

    min
  }

  private def topDown(matrix: Array[Array[Int]], r: Int, c: Int, mem: Array[Array[Int]]): Int = {
    if(c < 0 || c >= matrix(0).length) {
      return Integer.MAX_VALUE
    }
    if(r == matrix.length - 1) {
      return matrix(r)(c)
    }

    if(mem(r)(c) == 0) {
      mem(r)(c) = matrix(r)(c) + Integer.min(Integer.min(topDown(matrix, r+1, c-1, mem),
                                                         topDown(matrix, r+1,c, mem)),
                                             topDown(matrix, r+1, c+1,mem))
    }

    mem(r)(c)
  }
}
