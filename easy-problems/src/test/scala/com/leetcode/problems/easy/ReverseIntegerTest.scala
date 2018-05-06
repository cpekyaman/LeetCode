package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ReverseIntegerTest extends FunSuite {

  test("result for Int.MinValue overflow should be 0") {
    assert(ReverseInteger.reverse(Int.MinValue) == 0)
  }

  test("result for Int.MaxValue overflow should be 0") {
    assert(ReverseInteger.reverse(Int.MaxValue) == 0)
  }

  test("result for general overflow should be 0") {
    assert(ReverseInteger.reverse(1534236469) == 0)
  }

  test("result for 123 overflow should be 321") {
    assert(ReverseInteger.reverse(123) == 321)
  }

  test("result for -123 overflow should be -321") {
    assert(ReverseInteger.reverse(-123) == -321)
  }

  test("result for 120 overflow should be 21") {
    assert(ReverseInteger.reverse(120) == 21)
  }
}
