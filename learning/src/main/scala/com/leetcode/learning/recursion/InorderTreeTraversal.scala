package com.leetcode.learning.recursion

object InorderTreeTraversal {
  def traverse(root: TreeNode): List[Int] = {
    if(root == null) {
      return List.empty
    }

    val nums = scala.collection.mutable.ListBuffer[Int]()
    val nodes = scala.collection.mutable.Stack[TreeNode]()

    var node = root

    while(node != null || nodes.nonEmpty) {
      while(node != null) {
        nodes.push(node)
        node = node.left
      }

      node = nodes.pop()
      nums += node.value
      node = node.right
    }

    nums.toList
  }

}
