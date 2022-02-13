package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MeetingRoomsTest extends FunSuite {

  List((Array(Array(0,30), Array(5,10), Array(15,20)), false),
       (Array(Array(7,10), Array(2,4)), true)).foreach{ in =>

    test(s"should determine if attendance is possible for ${in._1.mkString(",")}") {
      assert(MeetingRooms.canAttendAll(in._1) == in._2)
    }
  }
}
