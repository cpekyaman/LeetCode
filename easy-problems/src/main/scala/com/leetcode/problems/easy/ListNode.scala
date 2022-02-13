package com.leetcode.problems.easy

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = s"(${this.x})"
}

object ListNode {
  def apply(x: Int): ListNode = new ListNode(x)

  def apply(x: Int, next: ListNode): ListNode = new ListNode(x, next)
}
