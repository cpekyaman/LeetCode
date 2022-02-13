package com.leetcode.problems.easy

object ContainsDuplicate {

  def check(nums: Array[Int]): Boolean = {
    if(nums == null || nums.length <= 1) {
      return false
    }

    val sortedNums = nums.sorted

    for(i <- 1 until sortedNums.length) {
      if(sortedNums(i) == sortedNums(i-1)) {
        return true
      }
    }
    false
  }
}
