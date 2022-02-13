package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class XToPowerNTest extends FunSuite {

  test("x to power 0 should be 1 for recursive") {
    assert(XToPowerN.recursive(34.24, 0) == 1)
    assert(XToPowerN.recursive(-5, 0) == 1)
    assert(XToPowerN.recursive(0, 0) == 1)
  }

  test("should calculate x**n correctly for recursive") {
    assert(XToPowerN.recursive(2.000, 10) == 1024.000)
    assert(XToPowerN.recursive(2.000, -2) == 0.25)
    //assert(XToPowerN.recursive(2.10000, 3) == 9.26100)
  }

  test("x to power 0 should be 1 for nonRecursive") {
    assert(XToPowerN.nonRecursive(34.24, 0) == 1)
    assert(XToPowerN.nonRecursive(-5, 0) == 1)
    assert(XToPowerN.nonRecursive(0, 0) == 1)
  }

  test("should calculate x**n correctly for nonRecursive") {
    assert(XToPowerN.nonRecursive(2.000, 10) == 1024.000)
    assert(XToPowerN.nonRecursive(2.000, -2) == 0.25)
    assert(XToPowerN.nonRecursive(2.10000, 3) == 9.26100)
  }
}
