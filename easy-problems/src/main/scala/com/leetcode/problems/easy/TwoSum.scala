package com.leetcode.problems.easy

object TwoSum {
  import scala.collection.mutable.{Map => MuMap}

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    // return as not found for less then two elements
    if(nums.length <= 1) {
      return Array(-1,-1)
    }

    val numToIndex: MuMap[Int, Int] = MuMap()

    for(numPos <- nums.indices) {
      val addendToFind = target - nums(numPos)

      // if matching added found, return
      // else put self as addend for coming pos
      if(numToIndex.contains(addendToFind)) {
        return Array(numToIndex(addendToFind), numPos)
      } else {
        numToIndex += (nums(numPos) -> numPos)
      }
    }

    Array(-1,-1)
  }
}
