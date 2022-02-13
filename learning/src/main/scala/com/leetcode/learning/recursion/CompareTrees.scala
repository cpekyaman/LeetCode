package com.leetcode.learning.recursion

object CompareTrees {
  import scala.collection.mutable

  def isSame(p: TreeNode, q: TreeNode): Boolean = {
    iterate(p, q)
  }

  private def recurse(p: TreeNode, q: TreeNode): Boolean = {
    same(p, q) && recurse(p.left, q.left) && recurse(p.right, q.right)
  }

  private def iterate(p: TreeNode, q: TreeNode): Boolean = {
    if(! same(p, q)) {
      return false
    }

    val pNodes = mutable.Queue[TreeNode]()
    val qNodes = mutable.Queue[TreeNode]()

    pNodes.enqueue(p)
    qNodes.enqueue(q)

    while(pNodes.nonEmpty) {
      val pCurr = pNodes.dequeue()
      val qCurr = qNodes.dequeue()

      if(! same(pCurr, qCurr)) {
        return false
      }

      if(pCurr != null) {
        if(! compare(pCurr.left, qCurr.left, pNodes, qNodes)) {
          return false
        }
        if(! compare(pCurr.right, qCurr.right, pNodes, qNodes)) {
          return false
        }
      }
    }

    true
  }

  private def compare(p: TreeNode, q: TreeNode,
                      pNodes: mutable.Queue[TreeNode],
                      qNodes: mutable.Queue[TreeNode]): Boolean = {

    if(! same(p, q)) {
      return false
    }
    if(p != null) {
      pNodes.enqueue(p)
      qNodes.enqueue(q)
    }
    true
  }

  private def same(p: TreeNode, q: TreeNode): Boolean = {
    if(p == null && q == null) {
      return true
    }
    if(p == null || q == null) {
      return false
    }

    p.value == q.value
  }
}
