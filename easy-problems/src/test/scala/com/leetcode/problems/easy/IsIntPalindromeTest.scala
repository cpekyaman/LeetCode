package com.leetcode.problems.easy

import org.scalatest.FunSuite

class IsIntPalindromeTest extends FunSuite {
  test("single digits are palindromes") {
    (0 until 10).foreach(i => assert(IsIntPalindrome.isPalindrome(i)))
  }

  test("two digit symmetric numbers are palindromes") {
    (0 until 10).foreach(i => assert(IsIntPalindrome.isPalindrome(i * 10 + i)))
  }

  test("1221 is palindrome") {
    assert(IsIntPalindrome.isPalindrome(1221))
  }

  test("1224 is NOT palindrome") {
    assert(!IsIntPalindrome.isPalindrome(1224))
  }

  test("1000001 is palindrome") {
    assert(IsIntPalindrome.isPalindrome(1000001))
  }

  test("Int.MIN is NOT palindrome") {
    assert(!IsIntPalindrome.isPalindrome(Int.MinValue))
  }

  test("234324534 is NOT palindrome") {
    assert(!IsIntPalindrome.isPalindrome(234324534))
  }
}
