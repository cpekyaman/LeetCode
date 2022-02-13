package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class InorderTreeTraversalTest extends FunSuite {

  test("should return empty list for null tree") {
    assert(InorderTreeTraversal.traverse(null) == List.empty[Int])
  }

  test("should return single element list for root only tree") {
    assert(InorderTreeTraversal.traverse(TreeNode(4)).equals(List(4)))
  }

  test("should traverse an arbitrary tree") {
    // given
    val root = TreeNode(4,
                        TreeNode(2,
                                 TreeNode(1),
                                 TreeNode(3)),
                        TreeNode(6,
                                 TreeNode(5),
                                 TreeNode(8)))

    assert(InorderTreeTraversal.traverse(root).equals(List(1,2,3,4,5,6,8)))
  }
}
