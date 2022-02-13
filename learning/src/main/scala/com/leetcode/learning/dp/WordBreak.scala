package com.leetcode.learning.dp

object WordBreak {
  def solve(s: String, dict: List[String]): Boolean = {
    bottomUp(s, dict)
    topDown(s, dict)
  }

  private def topDown(s: String, dict: List[String]): Boolean = {
    val mem = Array.fill[Int](s.length){ -1 }
    topDown(s, dict, s.length - 1, mem)
  }

  private def topDown(s: String, dict: List[String], i: Int, mem: Array[Int]): Boolean = {
    if(i < 0) {
      return true
    }

    if(mem(i) == -1) {
      for(w <- dict if mem(i) < 1) {
        if(i >= w.length - 1 && topDown(s, dict, i - w.length, mem)) {
          if(s.substring(i - w.length + 1, i + 1).equals(w)) {
            mem(i) = 1
          }
        }
      }
    }

    mem(i) == 1
  }

  private def bottomUp(s: String, dict: List[String]): Boolean = {
    val dp = Array.fill[Boolean](s.length){ false }

    for(i <- 0 until s.length) {
      for(w <- dict if !dp(i)) {
        if(i >= w.length - 1 && (i == w.length - 1 || dp(i - w.length))) {
          if(s.substring(i - w.length + 1, i + 1).equals(w)) {
            dp(i) = true
          }
        }
      }
    }

    dp(s.length - 1)
  }
}
