package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class ReverseLinkedListTest extends FunSuite {

  test("reverse of null list is itself") {
    assert(ReverseLinkedList.reverse(null) == null)
  }

  test("reverse of single node list is itself") {
    // given
    val node = ListNode(0)

    // when / then
    assert(ReverseLinkedList.reverse(node) == node)
  }

  test("reverse of list is the list from tail to head") {
    // given
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

    // when
    val reverse = ReverseLinkedList.reverse(head);

    // then
    assert(reverse == ListNode(5))
    assert(reverse.next == ListNode(4))
  }
}
