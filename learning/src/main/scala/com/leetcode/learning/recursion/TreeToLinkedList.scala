package com.leetcode.learning.recursion

object TreeToLinkedList {
  private var treeMin: Node = _
  private var treeMax: Node = _

  def convert(root: Node): Node = {
    if(root == null) {
      return null
    }

    treeMax = null
    treeMin = null

    convertRecursive(root, null, null)
    treeMin.left = treeMax
    treeMax.right = treeMin

    treeMin
  }

  // pred: a non-immediate left parent node
  // succ: a non-immediate right parent node
  private def convertRecursive(node: Node, pred: Node, succ: Node): Unit = {
    if(node == null) {
      return
    }

    convertRecursive(node.left, pred, node)
    convertRecursive(node.right, node, succ)

    // we are either a left leaf of a right tree of a pred node
    // or we are the left most child of the leftmost tree
    if(node.left == null) {
      if(pred != null) {
        pred.right = node
        node.left = pred
      } else {
        // since we start with pred:null and succ:null from root,
        // this is left most node when this condition is reached
        treeMin = node
      }
    }

    // we are either a right leaf of a left tree of a succ node
    // or we are the right most child of the rightmost tree
    if(node.right == null) {
      if(succ != null) {
        succ.left = node
        node.right = succ
      } else {
        // since we start with pred:null and succ:null from root,
        // this is right most node when this condition is reached
        treeMax = node
      }
    }
  }

  private def convertMinMaxTree(node: Node): (Node, Node) = {
    if(node == null) {
      return nilMinMax
    }

    val (leftMin, leftMax) = convertMinMaxTree(node.left)
    val (rightMin, rightMax) = convertMinMaxTree(node.right)

    node.left = leftMax
    node.right = rightMin

    if(leftMax != null) {
      leftMax.right = node
    }
    if(rightMin != null) {
      rightMin.left = node
    }

   (if(leftMin != null) leftMin else node, if(rightMax != null) rightMax else node)
  }

  private val nilMinMax: (Node, Node) = (null, null)
}
