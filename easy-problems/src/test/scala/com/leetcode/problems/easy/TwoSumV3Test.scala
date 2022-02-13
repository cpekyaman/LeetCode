package com.leetcode.problems.easy

import org.scalatest.FunSuite

class TwoSumV3Test extends FunSuite {

  test("should return false for empty data structure") {
    assert(! new TwoSumV3().find(5))
  }

  test("should return true if pairs are found") {
    // given
    val tw = new TwoSumV3()

    // when
    tw.add(1)
    tw.add(3)
    tw.add(2)
    tw.add(4)

    assert(! tw.find(9))
    assert(tw.find(7))
    assert(tw.find(5))
  }
}

