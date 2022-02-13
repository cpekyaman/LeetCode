package com.leetcode.problems.easy

object RangeSumOfBST {
  def calculate(root: TreeNode, low: Int, high: Int): Int = {
    if(root == null) {
      return 0
    }

    var ans = if(root.value >= low && root.value <= high) root.value else 0
    if(root.value > low) {
      ans += calculate(root.left, low, high)
    }

    if(root.value < high) {
      ans += calculate(root.right, low, high)
    }

    ans
  }
}
