package com.leetcode.problems.easy

object ClosestValueInTree {

  def find(root: TreeNode, target: Double): Int = {
    findInTree(root, target, root.value)
  }

  @scala.annotation.tailrec
  private def findInTree(node: TreeNode, target: Double, closest: Int): Int = {
    if(node == null) {
      return closest
    }

    val nodeValDouble = node.value.doubleValue()
    val newClosest = if(Math.abs(nodeValDouble - target) < Math.abs(closest.doubleValue() - target)) node.value else closest

    if(target > nodeValDouble) findInTree(node.right, target, newClosest) else findInTree(node.left, target, newClosest)
  }
}
