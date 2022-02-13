package com.leetcode.learning.recursion

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = s"(${this.x})"

  override def hashCode(): Int = 31 * this.x

  override def equals(obj: Any): Boolean = this.x == obj.asInstanceOf[ListNode].x
}

object ListNode {
  def apply(v: Int): ListNode = new ListNode(v)

  def apply(v: Int, n: ListNode) = new ListNode(v, n)
}
