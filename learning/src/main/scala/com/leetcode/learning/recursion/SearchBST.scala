package com.leetcode.learning.recursion

import scala.annotation.tailrec

object SearchBST {
  @tailrec
  def search(root: TreeNode, v: Int): TreeNode = {
    if(root == null || root.value == v) {
      return root
    }

    if(v < root.value)
      search(root.left, v)
    else
      search(root.right, v)
  }

}
