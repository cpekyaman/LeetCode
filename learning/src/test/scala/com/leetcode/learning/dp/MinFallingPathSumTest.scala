package com.leetcode.learning.dp

import org.scalatest.FunSuite

class MinFallingPathSumTest extends FunSuite {

  List((Array(Array(2,1,3), Array(6,5,4), Array(7,8,9)), 13),
       (Array(Array(-19,57), Array(-40,-5)), -59)).zipWithIndex.foreach{ m =>
    test(s"should find min falling path sum for ${m._2}") {
      assert(MinFallingPathSum.find(m._1._1) == m._1._2)
    }
  }
}
