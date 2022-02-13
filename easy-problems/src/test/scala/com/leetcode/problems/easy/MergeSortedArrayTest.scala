package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MergeSortedArrayTest extends FunSuite {

  List(
    (Array(1,2,3,0,0,0), 3, Array(2,5,6), 3, Array(1,2,2,3,5,6)),
    (Array(1), 1, Array[Int](), 0, Array(1)),
    (Array(0), 0, Array(2), 1, Array(2)),
    (Array(4,5,6,0,0,0), 3, Array(1,2,3), 3, Array(1,2,3,4,5,6))
    ).foreach{in =>

    test(s"merge of ${in._1.mkString(",")} and ${in._3.mkString(",")} is ${in._5.mkString(",")}") {
      // when
      MergeSortedArray.merge(in._1, in._2, in._3, in._4)

      // then
      assert(in._1.sameElements(in._5))
    }
  }
}
