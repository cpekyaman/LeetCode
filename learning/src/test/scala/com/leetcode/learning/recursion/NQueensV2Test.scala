package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class NQueensV2Test extends FunSuite {

  List((4,2), (1,1)).foreach{ n =>
    test(s"there should be ${n._2} ways to place ${n._1} queens") {
      assert(NQueensV2.solve(n._1) == n._2)
    }
  }
}
