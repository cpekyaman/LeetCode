package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class PascalTriangleTest extends FunSuite {

  test("row 0 is single 1") {
    assert(PascalTriangle.getRow(0) == List(1))
  }

  test("row 1 is two 1s") {
    assert(PascalTriangle.getRow(1) == List(1,1))
  }

  test("should calculate rows correctly") {
    assert(PascalTriangle.getRow(4) == List(1,4,6,4,1))
    assert(PascalTriangle.getRow(5) == List(1,5,10,10,5,1))
  }
}
