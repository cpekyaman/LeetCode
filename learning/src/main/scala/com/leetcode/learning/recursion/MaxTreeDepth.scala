package com.leetcode.learning.recursion

object MaxTreeDepth {
  def solve(root: TreeNode): Int = {
    if(root == null) {
      return 0
    }

    if(root.left == null && root.right == null) {
      return 1
    }

    Math.max(solve(root.left), solve(root.right)) + 1
  }
}
