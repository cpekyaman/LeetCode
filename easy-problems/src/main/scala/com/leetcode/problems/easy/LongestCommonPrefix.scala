package com.leetcode.problems.easy

object LongestCommonPrefix {

  def find(strs: Array[String]): String = {
    if(strs.isEmpty) "" else findPrefix(strs, 0, strs.length - 1)
  }

  private def findPrefix(strs: Array[String], lo: Int, hi: Int): String = {
    if(hi - lo == 1) {
      return findCommonPrefix(strs(lo), strs(hi))
    } else if(hi <= lo) {
      return strs(lo)
    }

    val mid = (hi + lo) / 2
    findCommonPrefix(findPrefix(strs, lo, mid), findPrefix(strs, mid + 1, hi))
  }

  private def findCommonPrefix(left: String, right: String): String = {
    if(left.isEmpty || right.isEmpty) {
      return ""
    }

    val len = Math.min(left.length, right.length)
    for{i <- 0 until len} {
      if(left.charAt(i) != right.charAt(i)) {
        return if(i > 0) left.substring(0, i) else ""
      }
    }

    left.substring(0, len)
  }
}
