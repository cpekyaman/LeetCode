package com.leetcode.problems.easy

object PalindromePermutation {

  def solve(s: String): Boolean = {
    if(s.length <= 1) {
      return true
    }

    if(s.length == 2) {
      return s.charAt(0) == s.charAt(1)
    }

    val charCounts = scala.collection.mutable.Map[Char, Int]()
    for(c <- s) {
      if(! charCounts.contains(c)) {
        charCounts.put(c, 1)
      } else {
        charCounts.update(c, charCounts(c)+1)
      }
    }

    charCounts.count(c => c._2 % 2 != 0) <= 1
  }
}
