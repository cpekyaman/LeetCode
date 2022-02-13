package com.leetcode.problems.easy

object ValidPalindrome {
  def determine(s: String): Boolean = {
    var left = 0
    var right = s.length - 1

    while(left < right) {
      while(left < right && ! Character.isLetterOrDigit(s.charAt(left))) {
        left += 1
      }
      while(right > left && ! Character.isLetterOrDigit(s.charAt(right))) {
        right -= 1
      }

      if(s.charAt(left).toLower != s.charAt(right).toLower) {
        return false
      }
      left += 1
      right -= 1
    }

    true
  }
}
