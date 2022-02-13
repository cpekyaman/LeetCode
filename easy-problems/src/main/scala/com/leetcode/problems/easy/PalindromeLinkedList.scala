package com.leetcode.problems.easy

object PalindromeLinkedList {
  def solve(head: ListNode): Boolean = {
    if(head == null || head.next == null) {
      return true
    }

    var node = head
    var size = 0
    // all digits except one should occur even number of times
    val digitCounts = Array.ofDim[Int](10)
    // the sum of their positions should add up to multiple of (size-1)
    val digitPosSum = Array.fill[Int](10) { -1 }

    while(node != null) {
      val num = node.x
      if(digitPosSum(num) < 0) {
        digitPosSum(num) = 0
      }
      digitPosSum(num) += size
      digitCounts(num) += 1
      node = node.next
      size += 1
    }

    // check if all digits except one in center(possibly) are in symmetric positions
    var oddElementFound = false
    for(i <- digitPosSum.indices if digitPosSum(i) >= 0) {
      if(digitCounts(i) % 2 == 0 && digitPosSum(i) % (size-1) != 0) {
        return false
      }

      // we allow one digit at the center for odd length lists
      if(digitCounts(i) % 2 != 0) {
        if(oddElementFound) {
          return false
        }
        oddElementFound = true
      }
    }
    true
  }
}
