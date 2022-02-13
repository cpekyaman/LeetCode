package com.leetcode.learning.dp

object LongestCommonSubsequence {
  def find(text1: String, text2: String): Int = {
    val mem = Array.fill[Int](text1.length, text2.length) {-1}
    topDown(text1, text2, text1.length - 1, text2.length - 1, mem)

    bottomUp(text1, text2)
  }

  private def topDown(t1: String, t2: String, i: Int, j: Int, mem: Array[Array[Int]]): Int = {
    if(i < 0 || j < 0) {
      return 0
    }

    if(mem(i)(j) == -1) {
      val dpij = if(t1.charAt(i) == t2.charAt(j)) {
        1 + topDown(t1, t2, i - 1, j - 1, mem)
      } else {
        Integer.max(topDown(t1, t2, i, j - 1, mem), topDown(t1, t2, i - 1, j, mem))
      }
      mem(i)(j) = dpij
    }

    mem(i)(j)
  }

  private def bottomUp(t1: String, t2: String): Int = {
    val n = t1.length
    val m = t2.length

    val dp = Array.ofDim[Int](n+1, m+1)

    for(i <- 0 until n) {
      for(j <- 0 until m) {
        dp(i+1)(j+1) = if(t1(i) == t2(j)) 1 + dp(i)(j) else Integer.max(dp(i)(j+1), dp(i+1)(j))
      }
    }

    dp(n)(m)
  }
}
