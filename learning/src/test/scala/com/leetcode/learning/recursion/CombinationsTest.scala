package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class CombinationsTest extends FunSuite {

  test("should solve (n,k)=(1,1)") {
    assert(Combinations.find(1,1).equals(List(List(1))))
  }

  test("should solve (n,k)=(2,2)") {
    assert(Combinations.find(2,2).equals(List(List(1, 2))))
  }

  test("should solve (n,k)=(4,2)") {
    assert(Combinations.find(4,2).equals(List(List(1, 2),List(1, 3),List(1, 4),List(2, 3),List(2, 4),List(3, 4))))
  }
}
