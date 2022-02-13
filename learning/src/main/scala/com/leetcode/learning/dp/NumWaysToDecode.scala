package com.leetcode.learning.dp

object NumWaysToDecode {
  def solve(s: String): Int = {
    bottomUp(s)
  }

  private def topDown(s: String): Int = {
    val mem = Array.ofDim[Int](s.length)
    topDown(s, 0, mem)
  }

  private def topDown(s: String, i: Int, mem: Array[Int]): Int = {
    if(s.charAt(0) == '0') {
      return 0
    }

    if(i >= s.length - 1) {
      return 1
    }

    if(mem(i) == 0) {
      var ans = topDown(s, i+1, mem)

      val twoDigit = Integer.parseInt(s.substring(i, i + 2))
      ans += (if(10 <= twoDigit && twoDigit <= 26) topDown(s, i+2, mem) else 0)

      mem(i) = ans
    }

    mem(i)
  }

  private def bottomUp(s: String): Int = {
    if(s.charAt(0) == '0') {
      return 0
    }

    var prevBeforeLast = 1
    var last = 1

    for(i <- 1 until s.length) {
      var current = if(s.charAt(i) != '0') last else 0

      val twoDigit = Integer.parseInt(s.substring(i - 1, i + 1))
      current += (if(10 <= twoDigit && twoDigit <= 26) prevBeforeLast else 0)

      prevBeforeLast = last
      last = current
    }

    last
  }
}
