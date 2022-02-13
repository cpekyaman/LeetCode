package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class PermutationsTest extends FunSuite {

  test("should generate permutations for two numbers") {
    assert(Permutations.generate(Array(3,7)).equals(List(List(3,7), List(7,3))))
  }

  test("should generate permutations for three numbers") {
    assert(Permutations.generate(Array(1,2,3)).equals(List(List(1,2,3), List(1,3,2))))
  }
}
