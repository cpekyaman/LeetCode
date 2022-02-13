package com.leetcode.learning.recursion

object LevelOrderTreeTraversal {
  import scala.collection.mutable
  import scala.collection.mutable.ListBuffer

  def traverse(root: TreeNode): List[List[Int]] = {
    if(root == null) {
      return List.empty[List[Int]]
    }

    val nums = ListBuffer[ListBuffer[Int]]()
    val nodes = mutable.Stack[NodeLevel]()

    var node = NodeLevel(root, 0)
    while(node != null || nodes.nonEmpty) {
      while(node != null) {
        if(nums.size == node.level) {
          nums += ListBuffer[Int]()
        }
        nodes.push(node)
        node = node.left
      }

      node = nodes.pop()
      nums(node.level) += node.node.value
      node = node.right
    }

    nums.foreach(println)
    nums.map(_.toList).toList
  }

  private case class NodeLevel(node: TreeNode, level: Int) {
    val left: NodeLevel = if(node.left != null) NodeLevel(node.left, level + 1) else null
    val right: NodeLevel = if(node.right != null) NodeLevel(node.right, level + 1) else null
  }
}
