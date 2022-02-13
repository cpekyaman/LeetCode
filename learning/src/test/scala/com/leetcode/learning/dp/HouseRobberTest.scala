package com.leetcode.learning.dp

import org.scalatest.FunSuite

class HouseRobberTest extends FunSuite {

  test("should find max robbed amount") {
    assert(HouseRobber.rob(Array(5)) == 5)
    assert(HouseRobber.rob(Array(2, 6)) == 6)
    assert(HouseRobber.rob(Array(7, 3)) == 7)
    assert(HouseRobber.rob(Array(2,7,9,3,1)) == 12)
  }
}
