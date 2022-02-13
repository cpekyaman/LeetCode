package com.leetcode.learning.dp

object LongestIncreasingSubsequence {
  def find(nums: Array[Int]): Int = {
    topDown(nums)
    bottomUp(nums)
  }

  private def bottomUp(nums: Array[Int]): Int = {
    val dp = Array.fill[Int](nums.length) {1}

    for(i <- 1 until nums.length) {
      for(j <- 0 until i if nums(j) < nums(i)) {
        dp(i) = Integer.max(dp(i), dp(j) + 1)
      }
    }

    dp.max
  }

  private def topDown(nums: Array[Int]): Int = {
    val mem = Array.fill[Int](nums.length) {0}
    nums.indices.foreach(i => topDown(nums, i, mem))
    mem.max
  }

  private def topDown(nums: Array[Int], i: Int, mem: Array[Int]): Int = {
    if(i == nums.length) {
      return 0
    }

    if(mem(i) > 0) {
      return mem(i)
    }

    var max = 0
    for(j <- i+1 until nums.length) {
      if(nums(i) < nums(j)) {
        max = Integer.max(topDown(nums, j, mem), max)
      }
    }
    mem(i) = max + 1
    mem(i)
  }
}
