package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class QuickSortTest extends FunSuite {

  test("sorting empty array should do nothing") {
    assert(QuickSort.sort(Array()).isEmpty)
  }

  List((Array(1,5,3,2,8,7,6,4), Array(1,2,3,4,5,6,7,8)),
       (Array(3,-4,5,6,-1,7), Array(-4,-1,3,5,6,7))).foreach{ a =>

    test(s"should be able to sort ${a._1.mkString(",")}") {
      assert(QuickSort.sort(a._1).sameElements(a._2))
    }
  }
}
