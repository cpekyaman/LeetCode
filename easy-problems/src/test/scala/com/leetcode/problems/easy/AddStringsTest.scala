package com.leetcode.problems.easy

import org.scalatest.FunSuite

class AddStringsTest extends FunSuite {

  List(("123","11", "134"), ("456", "77", "533")).foreach{in =>
    test(s"addition of ${in._1} and ${in._2} is ${in._3}") {
      assert(AddStrings.add(in._1, in._2).equals(in._3))
    }
  }
}
