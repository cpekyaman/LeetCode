package com.leetcode.problems.easy

object MeetingRooms {

  def canAttendAll(intervals: Array[Array[Int]]): Boolean = {
    val sorted = intervals.sortWith((left, right) => left(0) <= right(0))

    for(i <- 1 until sorted.length) {
      if(sorted(i)(0) < sorted(i-1)(1)) {
        return false
      }
    }

    true
  }
}
