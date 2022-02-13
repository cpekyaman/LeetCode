package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ClosestValueInTreeTest extends FunSuite {

  test("should return root value for single node tree") {
    assert(ClosestValueInTree.find(TreeNode(3), 3.4646) == 3)
  }

  test("should return the closest value in tree") {
    // given
    val root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(5))

    assert(ClosestValueInTree.find(root, 3.7345) == 4)
    assert(ClosestValueInTree.find(root, 3.3245) == 3)
    assert(ClosestValueInTree.find(root, 3.000) == 3)
    assert(ClosestValueInTree.find(root, 0.54) == 1)
    assert(ClosestValueInTree.find(root, 8.5454) == 5)
    assert(ClosestValueInTree.find(root, -2.4545) == 1)
  }
}
