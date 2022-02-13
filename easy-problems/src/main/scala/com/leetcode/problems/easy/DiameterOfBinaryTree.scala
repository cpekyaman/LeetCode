package com.leetcode.problems.easy

object DiameterOfBinaryTree {
  def calculate(root: TreeNode): Int = {
    diameter(root).d
  }

  private def diameter(node: TreeNode): NodeInfo = {
    if(node == null) {
      return new NodeInfo(0, 0)
    }

    val left = diameter(node.left)
    val right = diameter(node.right)

    val d = left.height + right.height

    new NodeInfo(Integer.max(d, Integer.max(left.d, right.d)),
                 1 + Integer.max(left.height, right.height))
  }

  private class NodeInfo(var d: Int, var height: Int)
}
