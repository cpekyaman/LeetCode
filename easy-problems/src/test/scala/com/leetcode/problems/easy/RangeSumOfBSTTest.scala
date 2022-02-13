package com.leetcode.problems.easy

import org.scalatest.FunSuite

class RangeSumOfBSTTest extends FunSuite {

  test("should return 0 for null tree") {
    assert(RangeSumOfBST.calculate(null, 0, 1000) == 0)
  }

  List((7, 15, 32), (4,8,12), (20,25,0), (1,4,3)).foreach{ in =>
    test(s"sum of nodes in range ${in._1}, ${in._2} should be ${in._3}") {
      // given
      val root = TreeNode(10, TreeNode(5, TreeNode(3), TreeNode(7)), TreeNode(15, null, TreeNode(18)))

      // when
      val sum = RangeSumOfBST.calculate(root, in._1, in._2)

      // then
      assert(sum == in._3)
    }
  }
}
