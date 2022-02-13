package com.leetcode.learning.recursion

import org.scalatest.{FunSuite, Ignore}

class Search2DMatrixTest extends FunSuite {

  test("should return false for empty matrix") {
    assert(! Search2DMatrix.search(Array(), 4))
  }

  test("should return false for single cell matrix if number is not found") {
    assert(! Search2DMatrix.search(Array(Array(3)), 4))
  }

  test("should return true for single cell matrix if number is found") {
    assert(Search2DMatrix.search(Array(Array(5)), 5))
  }

  test("should work with 2x2 matrix") {
    // given
    val matrix = Array(Array(3, 5), Array(4, 7))

    // when / then
    assert(Search2DMatrix.search(matrix, 3))
    assert(Search2DMatrix.search(matrix, 5))
    assert(Search2DMatrix.search(matrix, 4))
    assert(Search2DMatrix.search(matrix, 7))

    assert(! Search2DMatrix.search(matrix, 1))
    assert(! Search2DMatrix.search(matrix, 9))
  }

  test("should work with 3x3 matrix") {
    // given
    val matrix = Array(Array(2, 4, 6),
                       Array(4, 5, 7),
                       Array(5, 6, 9))

    // when / then
    assert(Search2DMatrix.search(matrix, 2))
    assert(Search2DMatrix.search(matrix, 5))
    assert(Search2DMatrix.search(matrix, 4))
    assert(Search2DMatrix.search(matrix, 6))
    assert(Search2DMatrix.search(matrix, 9))

    assert(! Search2DMatrix.search(matrix, 3))
    assert(! Search2DMatrix.search(matrix, 8))
    assert(! Search2DMatrix.search(matrix, 10))
  }


  test("should work with 5x5 matrix") {
    // given
    val matrix = Array(Array(1,4,7,11,15),
                       Array(2,5,8,12,19),
                       Array(3,6,9,16,22),
                       Array(10,13,14,17,24),
                       Array(18,21,23,26,30))

    // when / then
    assert(Search2DMatrix.search(matrix, 1))
    assert(Search2DMatrix.search(matrix, 15))
    assert(Search2DMatrix.search(matrix, 18))
    assert(Search2DMatrix.search(matrix, 30))

    assert(Search2DMatrix.search(matrix, 6))
    assert(Search2DMatrix.search(matrix, 17))
    assert(Search2DMatrix.search(matrix, 7))
    assert(Search2DMatrix.search(matrix, 23))

    assert(! Search2DMatrix.search(matrix, 35))
    assert(! Search2DMatrix.search(matrix, 20))
    assert(! Search2DMatrix.search(matrix, 27))
  }

}
