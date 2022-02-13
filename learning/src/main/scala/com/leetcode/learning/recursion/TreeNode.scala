package com.leetcode.learning.recursion

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  val value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right

  override def toString: String = s"${this.value}"
}

object TreeNode {
  def apply(v: Int): TreeNode = new TreeNode(v)

  def apply(v: Int, l: TreeNode): TreeNode = new TreeNode(v, l)

  def apply(v: Int, l: TreeNode, r: TreeNode): TreeNode = new TreeNode(v, l, r)
}
