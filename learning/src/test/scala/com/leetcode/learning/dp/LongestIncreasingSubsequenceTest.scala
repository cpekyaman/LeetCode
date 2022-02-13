package com.leetcode.learning.dp

import org.scalatest.FunSuite

class LongestIncreasingSubsequenceTest extends FunSuite {

  test("should find longest sequence length") {
    assert(LongestIncreasingSubsequence.find(Array(10,9,2,5,3,7,101,18)) == 4)
    assert(LongestIncreasingSubsequence.find(Array(0,1,0,3,2,3)) == 4)
    assert(LongestIncreasingSubsequence.find(Array(7,7,7,7,7,7,7)) == 1)
    assert(LongestIncreasingSubsequence.find(Array(1,3,6,7,9,4,10,5,6)) == 6)
  }
}
