package com.leetcode.learning.dp

object MaxSquareOfOnes {
  def find(matrix: Array[Array[Char]]): Int = {
    //topDown(matrix)
    bottomUp(matrix)
  }

  private def bottomUp(matrix: Array[Array[Char]]): Int = {
    val m = matrix.length
    val n = if(m > 0) matrix(0).length else 0

    val dp = Array.ofDim[Int](m+1, n+1)

    var max = 0
    for(i <- 1 to m) {
      for(j <- 1 to n) {
        dp(i)(j) = if(matrix(i-1)(j-1) == '1') {
          1 + Integer.min(Integer.min(dp(i-1)(j),dp(i)(j-1)), dp(i-1)(j-1))
        } else {
          0
        }
        max = Integer.max(max, dp(i)(j))
      }
    }

    max * max
  }

  private def topDown(matrix: Array[Array[Char]]): Int = {
    val m = matrix.length
    val n = if(m > 0) matrix(0).length else 0

    val mem = Array.fill[Int](m, n){-1}

    var max = 0
    for(i <- 0 until m) {
      for(j <- 0 until n) {
        max = Integer.max(topDown(matrix, i, j, mem), max)
      }
    }

    max * max
  }

  private def topDown(matrix: Array[Array[Char]], m: Int, n: Int, mem: Array[Array[Int]]): Int = {
    if(m < 0 || n < 0) {
      return 0
    }

    if(mem(m)(n) == -1) {
      if(matrix(m)(n) == '0') {
        mem(m)(n) = 0
      } else {
        mem(m)(n) = 1 + Integer.min(Integer.min(topDown(matrix, m-1, n, mem),
                                                topDown(matrix, m-1,n-1,mem)),
                                    topDown(matrix, m,n-1,mem))
      }
    }

    mem(m)(n)
  }
}
