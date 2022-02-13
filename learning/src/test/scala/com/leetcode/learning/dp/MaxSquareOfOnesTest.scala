package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MaxSquareOfOnesTest extends FunSuite {

  test("should find max square of ones") {
    assert(MaxSquareOfOnes.find(Array.ofDim(0,0)) == 0)

    assert(MaxSquareOfOnes.find(Array(Array('0'))) == 0)

    assert(MaxSquareOfOnes.find(Array(Array('1'))) == 1)

    assert(MaxSquareOfOnes.find(Array(Array('1','0','1','0','0'),
                                      Array('1','0','1','1','1'),
                                      Array('1','1','1','1','1'),
                                      Array('1','0','0','1','0'))) == 4)

    assert(MaxSquareOfOnes.find(Array(Array('0','1'),
                                      Array('1','0'))) == 1)
  }
}
