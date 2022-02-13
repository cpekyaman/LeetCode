package com.leetcode.learning.recursion

object ValidateBST {
  def validate(root: TreeNode): Boolean = {
    validate(root, Long.MinValue, Long.MaxValue)
  }

  private def validate(node: TreeNode, min: Long, max: Long): Boolean = {
    if(node == null) {
      return true
    }

    if(node.value >= max || node.value <= min) {
      return false
    }

    validate(node.left, min, node.value) && validate(node.right, node.value, max)
  }
}
