package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class LetterCombinationsTest extends FunSuite {

  test("should return empty list of empty digits") {
    assert(LetterCombinations.find("").equals(List.empty[String]))
  }

  List(("2", List("a", "b", "c")),
       ("7", List("p", "q", "r", "s"))).foreach{ in =>
    test(s"should return list of single letters for single digit ${in._1}") {
      assert(LetterCombinations.find(in._1).equals(in._2))
    }
  }

  List(("23", List("ad","ae","af","bd","be","bf","cd","ce","cf"))).foreach{ in =>
    test(s"should return list of letter combinations with double digit ${in._1}") {
      assert(LetterCombinations.find(in._1).equals(in._2))
    }
  }
}
