package com.leetcode.learning.dp

object NthTribonacci {
  def solve(n: Int): Int = {
    if(n <= 2) {
      return if(n == 0) 0 else 1
    }

    var f0 = 0
    var f1,f2 = 1
    for(_ <- 3 to n) {
      val current = f0 + f1 + f2
      f0 = f1
      f1 = f2
      f2 = current
    }
    f2
  }
}
