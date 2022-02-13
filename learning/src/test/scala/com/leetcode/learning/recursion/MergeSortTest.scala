package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class MergeSortTest extends FunSuite {

  test("should be able to sort unsorted array") {
    assert(MergeSort.sort(Array(1,5,3,2,8,7,6,4)).sameElements(Array(1,2,3,4,5,6,7,8)))
  }
}
