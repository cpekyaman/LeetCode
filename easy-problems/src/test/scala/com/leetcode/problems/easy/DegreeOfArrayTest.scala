package com.leetcode.problems.easy

import org.scalatest.FunSuite

class DegreeOfArrayTest extends FunSuite {

  List((Array(1,2,2,3,1), 2), (Array(1,2,2,3,1,4,2), 6), (Array(2), 1),
       (Array(2,1,1,2,1,3,3,3,1,3,1,3,2), 7)).foreach{ in =>
    test(s"length of subarray with same degree as ${in._1.mkString(",")} is ${in._2}") {
      assert(DegreeOfArray.find(in._1) == in._2)
    }
  }
}
