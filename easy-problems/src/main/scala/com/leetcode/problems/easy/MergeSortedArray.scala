package com.leetcode.problems.easy

object MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {

    var pos1 = m - 1
    var pos2 = n - 1
    var dest = nums1.length - 1

    while(dest >= 0 && pos2 >= 0) {
      if(pos1 < 0) {
        nums1(dest) = nums2(pos2)
        dest -= 1
        pos2 -= 1
      } else if(nums1(pos1) > nums2(pos2)) {
        nums1(dest) = nums1(pos1)
        dest -= 1
        pos1 -= 1
      } else {
        nums1(dest) = nums2(pos2)
        dest -= 1
        pos2 -= 1
      }
    }
  }
}
