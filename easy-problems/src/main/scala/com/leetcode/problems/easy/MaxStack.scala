package com.leetcode.problems.easy

class MaxStack {
  private var head: Node = null
  private val sorted = scala.collection.mutable.TreeMap[Int, List[Node]]()

  def push(x: Int) {
    val node = updateStack(x)
    updateMaxTree(x, node)
  }

  private def updateStack(x: Int): Node = {
    val node = new Node(x)
    if(head == null) {
      head = node
    } else {
      node.next = head
      head.prev = node
      head = node
    }
    node
  }

  private def updateMaxTree(x: Int, node: Node): Unit = {
    if(sorted.contains(x)) {
      val nodes = sorted(x)
      sorted(x) = node :: nodes
    } else {
      sorted(x) = node :: List()
    }
  }

  def pop(): Int = {
    val headVal = head.x
    head = head.next
    if(head != null) {
      head.prev = null
    }

    val treeNodes = sorted(headVal)
    removeFromTree(headVal, treeNodes)
    headVal
  }

  def top(): Int = head.x

  def peekMax(): Int = sorted.last._2.head.x

  def popMax(): Int = {
    val (max, nodes) = sorted.last
    removeFromTree(max, nodes)
    remove(nodes.head)
    max
  }

  private def removeFromTree(n: Int, nodes: List[Node]): Unit = {
    if(nodes.size == 1) {
      sorted.remove(n)
    } else {
      sorted(n) = nodes.tail
    }
  }

  private def remove(node: Node): Unit = {
    if(node.prev != null) {
      node.prev.next = node.next
    } else {
      head = node.next
    }

    if(node.next != null) {
      node.next.prev = node.prev
    }
  }

  private class Node(val x: Int, var prev: Node = null, var next: Node = null) {
    override def toString: String = s"Node(${this.x})"
  }
}
