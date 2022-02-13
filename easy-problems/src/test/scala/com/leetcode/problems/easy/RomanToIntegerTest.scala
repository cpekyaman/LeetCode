package com.leetcode.problems.easy

import org.scalatest.FunSuite

class RomanToIntegerTest extends FunSuite {

  test("should return decimal value of single digit roman number") {
    assert(RomanToInteger.convert("M") == 1000)
    assert(RomanToInteger.convert("D") == 500)
    assert(RomanToInteger.convert("C") == 100)
    assert(RomanToInteger.convert("L") == 50)
    assert(RomanToInteger.convert("X") == 10)
    assert(RomanToInteger.convert("V") == 5)
    assert(RomanToInteger.convert("I") == 1)
  }

  test("should handle right to left cases") {
    assert(RomanToInteger.convert("CM") == 900)
    assert(RomanToInteger.convert("CD") == 400)
    assert(RomanToInteger.convert("XC") == 90)
    assert(RomanToInteger.convert("XL") == 40)
    assert(RomanToInteger.convert("IX") == 9)
    assert(RomanToInteger.convert("IV") == 4)
  }

  test("should return decimal value of valid roman number") {
    assert(RomanToInteger.convert("XXVII") == 27)
    assert(RomanToInteger.convert("III") == 3)
    assert(RomanToInteger.convert("LVIII") == 58)
    assert(RomanToInteger.convert("MCMXCIV") == 1994)
    assert(RomanToInteger.convert("CXIV") == 114)
    assert(RomanToInteger.convert("MMCCCXXV") == 2325)
    assert(RomanToInteger.convert("CDLXXVIII") == 478)
  }
}
