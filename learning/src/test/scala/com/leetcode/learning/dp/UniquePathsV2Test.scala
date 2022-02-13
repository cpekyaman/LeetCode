package com.leetcode.learning.dp

import org.scalatest.FunSuite

class UniquePathsV2Test extends FunSuite {

  test("should find paths in an obstacle grid") {
    // given
    val grid = Array(Array(0,0,0), Array(0,1,0), Array(0,0,0))

    // when / then
    assert(UniquePathsV2.find(grid) == 2)
  }
}
