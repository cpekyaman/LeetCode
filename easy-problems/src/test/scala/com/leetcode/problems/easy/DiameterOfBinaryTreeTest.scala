package com.leetcode.problems.easy

import org.scalatest.FunSuite

class DiameterOfBinaryTreeTest extends FunSuite {

  test("single node tree has a diameter of two") {
    // given
    val root = TreeNode(1)

    // when
    assert(DiameterOfBinaryTree.calculate(root) == 1)
  }

  test("two node tree has a diameter of two") {
    // given
    val root = TreeNode(1, null, TreeNode(2))

    // when
    assert(DiameterOfBinaryTree.calculate(root) == 1)
  }
}
