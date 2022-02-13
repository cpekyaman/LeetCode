package com.leetcode.problems.easy

object RomanToInteger {
  def convert(s: String): Int = {
    var num = 0
    var lastChar ='\u0000'
    for(i <- (0 until s.length).reverse) {
      s.charAt(i) match {
        case 'M' =>
          num += 1000
        case 'D' =>
          num += 500
        case 'L' =>
          num += 50
        case 'C' =>
          num += (if(lastChar == 'M' || lastChar == 'D') -100 else 100)
        case 'X' =>
          num += (if(lastChar == 'C' || lastChar == 'L') -10 else 10)
        case 'V' =>
          num += 5
        case 'I' =>
          num += (if(lastChar == 'V' || lastChar == 'X') -1 else 1)
      }
      lastChar = s.charAt(i)
    }

    num
  }
}
