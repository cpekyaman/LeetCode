package com.leetcode.problems.easy

import org.scalatest.FunSuite

class BinarySearchTest extends FunSuite {

  List((Array(1,2,3),4,-1), (Array(-1,0,3,5,9,12),9,4),
       (Array(-1,0,3,5,9,12),2,-1)).foreach{ in =>
    test(s"nums ${in._2} exists in ${in._1.mkString(",")} at pos ${in._3}") {
      assert(BinarySearch.search(in._1, in._2) == in._3)
    }
  }
}
