package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class MaxTreeDepthTest extends FunSuite {

  test("null tree should have zero depth") {
    assert(MaxTreeDepth.solve(null) == 0)
  }

  test("single node tree should have depth of one") {
    assert(MaxTreeDepth.solve(TreeNode(1)) == 1)
  }

  test("should find depth of a tree") {
    // given
    val root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))

    // when
    val depth = MaxTreeDepth.solve(root)

    // then
    assert(depth == 3)
  }
}
