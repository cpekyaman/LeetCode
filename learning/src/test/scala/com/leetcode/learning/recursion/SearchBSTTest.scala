package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class SearchBSTTest extends FunSuite {

  test("search int null tree should return null") {
    assert(SearchBST.search(null, 5) == null)
    assert(SearchBST.search(null, 1) == null)
    assert(SearchBST.search(null, -4) == null)
  }

  test("should return the subtree when number is found") {
    // given
    val root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))

    // when
    val subtree = SearchBST.search(root, 2)

    // then
    assert(subtree.value == 2)
    assert(subtree.left.value == 1)
    assert(subtree.right.value == 3)
  }

  test("should return null when number is not found") {
    // given
    val root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))

    // when
    val subtree = SearchBST.search(root, 8)

    // then
    assert(subtree == null)
  }
}
