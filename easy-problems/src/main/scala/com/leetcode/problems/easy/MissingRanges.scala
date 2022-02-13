package com.leetcode.problems.easy

object MissingRanges {
  import scala.collection.mutable.ListBuffer

  def find(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    if(nums.length == 0) {
      return List(rangeStr(lower, upper))
    }

    val ranges = ListBuffer[String]()
    if(nums(0) > lower) {
      ranges += rangeStr(lower, nums(0)-1)
    }

    for(i <- 1 until nums.length) {
      if(nums(i) > nums(i-1) + 1) {
        ranges += rangeStr(nums(i-1)+1, nums(i)-1)
      }
    }

    if(nums(nums.length-1) < upper) {
      ranges += rangeStr(nums(nums.length-1)+1, upper)
    }

    ranges.toList
  }

  private def rangeStr(lo: Int, hi: Int): String = {
    if(lo == hi) s"$lo" else s"$lo->$hi"
  }
}
