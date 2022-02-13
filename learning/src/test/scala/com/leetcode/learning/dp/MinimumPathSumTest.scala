package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MinimumPathSumTest extends FunSuite {

  List((Array(Array(1,3,1),Array(1,5,1),Array(4,2,1)), 7),
       (Array(Array(1,2,3), Array(4,5,6)), 12)).zipWithIndex.foreach{g =>
    test(s"should find minimum path sum for array ${g._2}") {
      // when / then
      assert(MinimumPathSum.find(g._1._1) == g._1._2)
    }
  }
}
