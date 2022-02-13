package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ContainsDuplicateTest extends FunSuite {

  List((Array(1,2,3,1), true), (Array(1,2,3,4), false), (Array(3), false),
       (Array(1,1,1,3,3,4,3,2,4,2), true), (Array[Int](), false), (Array(3,3), true)).foreach{ in =>
    test(s"${in._1.mkString(",")} contains duplicate is ${in._2}") {
      assert(ContainsDuplicate.check(in._1) == in._2)
    }
  }
}
