package com.leetcode.learning.dp

import org.scalatest.FunSuite

class LongestCommonSubsequenceTest extends FunSuite {

  test("should find longest common subsequence") {
    assert(LongestCommonSubsequence.find("abcde", "ace") == 3)
    assert(LongestCommonSubsequence.find("abc", "def") == 0)
    assert(LongestCommonSubsequence.find("abc", "abc") == 3)
  }
}
