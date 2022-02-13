package com.leetcode.problems.easy

object CanBePalindrome {
  def isTrue(str: String): Boolean = {
    isPalindrome(str, canSkip = true)
  }

  private def isPalindrome(str: String, canSkip: Boolean): Boolean = {
    var lo = 0
    var hi = str.length - 1

    while(lo <= hi) {
      if (str.charAt(lo) != str.charAt(hi)) {
        if(canSkip) {
          return isPalindrome(str.substring(lo + 1, hi + 1), canSkip = false) || isPalindrome(str.substring(lo, hi), canSkip = false)
        } else {
          return false
        }
      }
      lo += 1
      hi -= 1
    }

    true
  }
}
