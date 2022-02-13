package com.leetcode.learning.recursion

class Node(val value: Int, var left: Node = null, var right: Node = null) {

}

object Node {
  def apply(v: Int): Node = new Node(v)

  def apply(v: Int, left: Node) = new Node(v, left)

  def apply(v: Int, left: Node, right: Node) = new Node(v, left, right)
}
