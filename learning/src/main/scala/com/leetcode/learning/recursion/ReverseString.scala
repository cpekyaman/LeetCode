package com.leetcode.learning.recursion

import scala.annotation.tailrec

object ReverseString {
  def reverse(str: Array[Char]): Array[Char] = {
    reverseStr(str, 0, str.length - 1)
    str
  }

  @tailrec
  private def reverseStr(str: Array[Char], lo: Int, hi: Int): Unit = {
    if (hi <= lo) {
      return
    }
    swap(str, lo, hi)
    reverseStr(str, lo + 1, hi - 1)
  }

  private def swap(str: Array[Char], i: Int, j: Int): Unit = {
    val temp = str(i)
    str(i) = str(j)
    str(j) = temp
  }
}
