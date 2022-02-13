package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ValidPalindromeTest extends FunSuite {

  List(("A man, a plan, a canal: Panama", true), ("race a car", false),
       ("", true), ("  ", true), (" - :", true), ("$-()-", true)).foreach{ in =>
    test(s"string ${in._1} can be palindrome is ${in._2}") {
      assert(ValidPalindrome.determine(in._1) == in._2)
    }
  }
}
