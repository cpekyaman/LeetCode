package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class MergeTwoListsTest extends FunSuite {

  test("when first list is empty result should be second list") {
    // given
    val list2 = ListNode(1, ListNode(3, ListNode(4)))

    // when / then
    assert(MergeTwoLists.solve(null, list2) == list2)
  }

  test("when second list is empty result should be first list") {
    // given
    val list1 = ListNode(1, ListNode(3, ListNode(4)))

    // when / then
    assert(MergeTwoLists.solve(list1, null) == list1)
  }

  test("should merge two non-empty lists") {
    // given
    val list1 = new ListNode(-2, new ListNode(3, new ListNode(4)))
    val list2 = new ListNode(-1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(8)))))

    // when
    val merged = MergeTwoLists.solve(list1, list2)

    // then
    verify(merged, List(8,6,5,4,4,3,-1,-2))
  }

  private def verify(merged: ListNode, expected: List[Int]): Unit = {
    var node = merged
    var list = List[Int]()
    while(node != null) {
      list = node.x :: list
      node = node.next
    }
    assert(list == expected)
  }
}
