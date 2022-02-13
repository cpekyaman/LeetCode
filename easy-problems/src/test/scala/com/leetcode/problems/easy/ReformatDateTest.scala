package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ReformatDateTest extends FunSuite {

  List(("20th Oct 2052", "2052-10-20"), ("6th Jun 1933", "1933-06-06")).foreach{in =>
    test(s"formatted value of ${in._1} is ${in._2}") {
      assert(ReformatDate.format(in._1).equals(in._2))
    }
  }
}
