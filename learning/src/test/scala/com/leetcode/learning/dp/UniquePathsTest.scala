package com.leetcode.learning.dp

import org.scalatest.FunSuite

class UniquePathsTest extends FunSuite {

  List((3,7,28), (3,2,3)).foreach{ c =>
    test(s"unique paths for (${c._1},${c._2}) should be ${c._3}") {
      assert(UniquePaths.find(c._1, c._2) == c._3)
    }
  }
}
