package com.leetcode.problems.easy

import org.scalatest.FunSuite

class SortedListMergeTest extends FunSuite {

  test("should return empty list when inputs are empty") {
    assert(SortedListMerge.merge(null, null) == null)
  }

  test("should return first list when second list is empty") {
    assert(SortedListMerge.merge(new ListNode(1, new ListNode(2, new ListNode(3))), null).next.next.x == 3)
  }

  test("should return second list when first list is empty") {
    assert(SortedListMerge.merge(null, new ListNode(1, new ListNode(2, new ListNode(3)))).next.x == 2)
  }

  test("should return merged list with correct order for equal length lists") {
    // given
    val list1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val list2 = new ListNode(1, new ListNode(3, new ListNode(4)))

    // when
    val merged = SortedListMerge.merge(list1, list2)

    // then
    verify(merged, List(4, 4, 3, 2, 1, 1))
  }

  test("should return merged list with correct order when list1 is longer") {
    // given
    val list1 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(6))))
    val list2 = new ListNode(1, new ListNode(2, new ListNode(5)))

    // when
    val merged = SortedListMerge.merge(list1, list2)

    // then
    verify(merged, List(6,5,4,3,2,2,1))
  }

  test("should return merged list with correct order when list2 is longer") {
    // given
    val list1 = new ListNode(-2, new ListNode(3, new ListNode(4)))
    val list2 = new ListNode(-1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(8)))))

    // when
    val merged = SortedListMerge.merge(list1, list2)

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
