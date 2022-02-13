package com.leetcode.problems.easy

object SortedListMerge {
  def merge(list1: ListNode, list2: ListNode): ListNode = {
    // dummy start
    val head = new ListNode(0)

    var firstIter: ListNode = list1
    var secondIter: ListNode = list2

    var resIter = head
    while(firstIter != null && secondIter != null) {
      if(firstIter.x <= secondIter.x) {
        resIter.next = new ListNode(firstIter.x)
        firstIter = firstIter.next
      } else if(secondIter.x < firstIter.x){
        resIter.next = new ListNode(secondIter.x)
        secondIter = secondIter.next
      }

      resIter = resIter.next
    }

    var remain = if(firstIter != null) firstIter else secondIter
    while(remain != null) {
      resIter.next = remain
      remain = remain.next
      resIter = resIter.next
    }

    // skip dummy start node
    head.next
  }
}
