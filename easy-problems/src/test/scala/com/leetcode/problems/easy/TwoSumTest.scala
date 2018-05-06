package com.leetcode.problems.easy

import org.scalatest.FunSuite

class TwoSumTest extends FunSuite {

  test("result for empty array should be (-1,-1)") {
    assert(TwoSum.twoSum(Array.emptyIntArray, 5) sameElements Array(-1,-1) )
  }

  test("result for not found result should be (-1,-1)") {
    assert(TwoSum.twoSum(Array(2,3,4,5,7), 22) sameElements Array(-1,-1) )
    assert(TwoSum.twoSum(Array(2,3,4,5,7), 13) sameElements Array(-1,-1) )
  }

  test("result for found result should be found indices") {
    assert(TwoSum.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0,1) )
    assert(TwoSum.twoSum(Array(9, 11, 2, 15, 7), 9) sameElements Array(2,4) )
    assert(TwoSum.twoSum(Array(5, 9, 11, 3, 15, 7, 0), 11) sameElements Array(2,6) )
  }
}
