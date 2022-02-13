package com.leetcode.learning.dp

object PaintFence {
  def solve(n: Int, k: Int): Int = {
    bottomUp(n, k)
  }

  private def bottomUp(n: Int, k: Int): Int = {
    if(n == 1) {
      return k
    }
    if(n == 2) {
      return k * k
    }

    var prevBeforeLast = k
    var last = k * k

    (3 to n).foreach{ _ =>
      val current = (k -1) * (prevBeforeLast + last)
      prevBeforeLast = last
      last = current
    }

    last
  }
}
