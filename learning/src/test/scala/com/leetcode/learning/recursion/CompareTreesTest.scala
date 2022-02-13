package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class CompareTreesTest extends FunSuite {

  test("a null tree is the same as itself") {
    assert(CompareTrees.isSame(null, null))
  }

  test("a tree is the same as itself") {
    // given
    val tree = TreeNode(1, TreeNode(2), TreeNode(3, null, TreeNode(5)))

    // when / then
    assert(CompareTrees.isSame(tree, tree))
  }

  test("two trees with same structure are the same") {
    // given
    val first = TreeNode(3,
                         TreeNode(2,
                                  TreeNode(1), null),
                         TreeNode(4,
                                  null, TreeNode(5)))
    val second = TreeNode(3,
                          TreeNode(2,
                                   TreeNode(1), null),
                          TreeNode(4,
                                   null, TreeNode(5)))

    // when / then
    assert(CompareTrees.isSame(first, second))
  }
}
