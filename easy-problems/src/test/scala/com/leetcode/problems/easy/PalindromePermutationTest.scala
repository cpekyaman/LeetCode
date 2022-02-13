package com.leetcode.problems.easy

import org.scalatest.FunSuite

class PalindromePermutationTest extends FunSuite {

  List(("aab", true), ("code", false), ("carerac", true), ("ab", false),
       ("aaa", true), ("carecrac", false), ("a", true), ("aa", true), ("aabb", true)).foreach{ in =>
    test(s"input ${in._1} can generate palindrome is ${in._2}") {
      assert(PalindromePermutation.solve(in._1) == in._2)
    }
  }
}
