package com.leetcode.problems.easy

object DegreeOfArray {

  def find(nums: Array[Int]): Int = {
    // value of map is array with values as (degree,firstPosInArray,lastPosInArray)
    val degrees = scala.collection.mutable.Map[Int, Array[Int]]()

    var maxDegree = Integer.MIN_VALUE
    var maxDegreeNum = Integer.MIN_VALUE
    var minDegreeLen = Integer.MAX_VALUE

    for(i <- nums.indices) {
      val num = nums(i)
      if(! degrees.contains(num)) {
        degrees.put(num, Array(1, i, i))
      } else {
        val degree = degrees(num)
        degree(0) += 1
        degree(2) = i
      }

      val degree = degrees(num)
      if(degree(0) > maxDegree || (degree(0) == maxDegree && (degree(2) - degree(1) < minDegreeLen))) {
        maxDegree = degree(0)
        maxDegreeNum = num
        minDegreeLen = degree(2) - degree(1)
      }
    }

    val degree = degrees(maxDegreeNum)
    degree(2) - degree(1) + 1
  }
}
