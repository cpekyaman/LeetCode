package com.leetcode.learning.dp

object HouseRobber {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) {
      return nums(0)
    }

    var prevBeforeLast = nums(0)
    var last = Math.max(nums(1), nums(0))

    for(i <- 2 until nums.length) {
      val current = Integer.max(last, prevBeforeLast + nums(i))
      prevBeforeLast = last
      last = current
    }
    last
  }

}
