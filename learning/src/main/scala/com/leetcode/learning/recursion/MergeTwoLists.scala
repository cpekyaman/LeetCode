package com.leetcode.learning.recursion

object MergeTwoLists {
  def solve(list1: ListNode, list2: ListNode): ListNode = {
    if(list1 == null) return list2 else if(list2 == null) return list1

    val node = if (list1.x <= list2.x) list1 else list2
    node.next = if (list1.x <= list2.x) solve(list1.next, list2) else solve(list1, list2.next)

    node
  }

}
