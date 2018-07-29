package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ValidParenthesesTest extends FunSuite {
  test("empty string is valid") {
    assert(ValidParentheses.isValid(""))
  }

  test("() is valid") {
    assert(ValidParentheses.isValid("()"))
  }

  test("[] is valid") {
    assert(ValidParentheses.isValid("[]"))
  }

  test("{} is valid") {
    assert(ValidParentheses.isValid("{}"))
  }

  test("()[]{} is valid") {
    assert(ValidParentheses.isValid("()[]{}"))
  }

  test("(] is NOT valid") {
    assert(! ValidParentheses.isValid("(]"))
  }

  test("([)] is NOT valid") {
    assert(! ValidParentheses.isValid("([)]"))
  }

  test("{[]} is valid") {
    assert(ValidParentheses.isValid("{[]}"))
  }
}
