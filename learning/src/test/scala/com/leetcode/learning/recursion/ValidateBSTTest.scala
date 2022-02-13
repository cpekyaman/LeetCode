package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class ValidateBSTTest extends FunSuite {

  test("should return true for null tree") {
    assert(ValidateBST.validate(null))
  }

  test("should return true for single node tree") {
    assert(ValidateBST.validate(TreeNode(3)))
  }

  test("should return true if the tree is valid") {
    // given
    val root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))

    // when / then
    assert(ValidateBST.validate(root))
  }

  test("should return false if the tree is not valid") {
    // given
    val root = TreeNode(5, TreeNode(2,
                                    TreeNode(4), TreeNode(3)),
                        TreeNode(7))

    // when / then
    assert(! ValidateBST.validate(root))
  }
}
