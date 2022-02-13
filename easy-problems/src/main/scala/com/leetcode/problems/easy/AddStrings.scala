package com.leetcode.problems.easy

object AddStrings {
  def add(num1: String, num2: String): String = {
    var carry = 0
    var pos1 = num1.length - 1
    var pos2 = num2.length - 1

    var res = List[Char]()
    while(pos1 >= 0 || pos2 >= 0) {
      val x1 = if(pos1 >= 0) Character.getNumericValue(num1.charAt(pos1)) else 0
      val x2 = if(pos2 >= 0) Character.getNumericValue(num2.charAt(pos2)) else 0

      val curr = (x1 + x2 + carry) % 10
      carry = (x1 + x2 + carry) / 10

      res = ('0' + curr).toChar :: res

      pos1 -= 1
      pos2 -= 1
    }

    if(carry != 0) {
      res = ('0' + carry).toChar :: res
    }

    res.mkString("")
  }
}
