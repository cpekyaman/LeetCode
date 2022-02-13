package com.leetcode.problems.easy

object MaxSubArray {

  def find(nums: Array[Int]): Int = {
    var localMax = nums(0)
    var globalMax = nums(0)

    for{i <- 1 until nums.length} {
      localMax = Math.max(nums(i), nums(i) + localMax)
      globalMax = Math.max(globalMax, localMax)
    }

    globalMax
  }
}
