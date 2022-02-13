package com.leetcode.problems.easy

import org.scalatest.FunSuite

class CanBePalindromeTest extends FunSuite {

  test("single char string should be valid") {
    assert(CanBePalindrome.isTrue("a"))
  }

  test("two char string should be valid") {
    assert(CanBePalindrome.isTrue("aa"))
    assert(CanBePalindrome.isTrue("ab"))
    assert(CanBePalindrome.isTrue("ca"))
  }

  test("should return true if already palindrome") {
    assert(CanBePalindrome.isTrue("abba"))
    assert(CanBePalindrome.isTrue("rotator"))
  }

  test("should return true if only has one violating char") {
    assert(CanBePalindrome.isTrue("dabba"))
    assert(CanBePalindrome.isTrue("abbad"))
    assert(CanBePalindrome.isTrue("abca"))
    assert(CanBePalindrome.isTrue("rotaktor"))
  }

  test("should return false if there is more than one violating char") {
    assert(!CanBePalindrome.isTrue("abc"))
    assert(!CanBePalindrome.isTrue("rolaton"))
    assert(!CanBePalindrome.isTrue("cbda"))
    assert(!CanBePalindrome.isTrue("tenat"))
  }

  test("should return true for very long valid input") {
    assert(CanBePalindrome.isTrue("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"))
  }
}
