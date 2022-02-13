package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class LevelOrderTreeTraversalTest extends FunSuite {

  test("should return empty list for null tree") {
    assert(LevelOrderTreeTraversal.traverse(null) == List.empty[List[Int]])
  }

  test("should return single element list list for single node tree") {
    assert(LevelOrderTreeTraversal.traverse(TreeNode(4)).equals(List(List(4))))
  }

  test("should traverse arbitrary tree") {
    // given
    val root = TreeNode(3,
                        TreeNode(9),
                        TreeNode(20,
                                 TreeNode(15),
                                 TreeNode(7)))

    // when / then
    assert(LevelOrderTreeTraversal.traverse(root).equals(List(List(3), List(9,20), List(15,7))))
  }
}
