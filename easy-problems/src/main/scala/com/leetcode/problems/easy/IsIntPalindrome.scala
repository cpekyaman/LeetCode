package com.leetcode.problems.easy

object IsIntPalindrome {
  def divMul(acc: Int, rem: Int): Int = {
    if (rem < 10) acc * 10 + rem else divMul((acc * 10) + (rem % 10), rem / 10)
  }

  def isPalindrome(x: Int): Boolean = {
    if(x < 0) false else if(x < 10) true else divMul(0, x) == x
  }
}
