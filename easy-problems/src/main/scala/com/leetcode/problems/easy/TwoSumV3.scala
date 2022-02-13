package com.leetcode.problems.easy

class TwoSumV3 {
  import scala.collection.mutable.{Map => MMap}

  private val nums: MMap[Int, Int] = MMap[Int, Int]()

  def add(number: Int) {
    if(nums.contains(number)) {
      nums.update(number, nums(number) + 1)
    } else {
      nums.put(number, 1)
    }
  }

  def find(value: Int): Boolean = {
    for(e <- nums.keySet) {
      val comp = value - e
      if(nums.contains(comp)) {
        return comp != e || nums(e) > 1
      }
    }
    false
  }

}
