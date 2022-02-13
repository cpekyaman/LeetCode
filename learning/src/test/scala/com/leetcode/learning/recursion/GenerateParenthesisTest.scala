package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class GenerateParenthesisTest extends FunSuite {

  List((1, List("()")),
       (2, List("()()", "(())")),
       (3, List("()()()", "()(())", "(())()", "(()())", "((()))"))).foreach{ t =>
    test(s"should generate for ${t._1}") {
      assert(GenerateParenthesis.generate(t._1).equals(t._2))
    }
  }

}
