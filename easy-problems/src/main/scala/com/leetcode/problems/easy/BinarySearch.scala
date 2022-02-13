package com.leetcode.problems.easy

object BinarySearch {

  def search(nums: Array[Int], target: Int): Int = {
    search(nums, target, 0, nums.length - 1)
  }

  @scala.annotation.tailrec
  private def search(nums: Array[Int], target: Int, lo: Int, hi: Int): Int = {
    if(hi < lo) {
      return -1
    }

    if(target < nums(lo) || target > nums(hi)) {
      return -1
    }

    val mid = lo + (hi - lo) / 2
    if(target == nums(mid)) {
      return mid
    }

    if(target < nums(mid)) search(nums, target, lo, mid-1) else search(nums, target, mid+1, hi)
  }
}
