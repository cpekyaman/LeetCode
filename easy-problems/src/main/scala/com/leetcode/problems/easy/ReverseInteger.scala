package com.leetcode.problems.easy

object ReverseInteger {
  def reverse(input: Int): Int = {
    val result = (if(input.signum < 0) "-" else "").concat(input.toLong.abs.toString.reverse).toLong
    if (result <= Int.MaxValue && result >= Int.MinValue) result.intValue() else 0
  }
}
