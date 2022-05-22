package com.leetcode.problems.easy

import org.scalatest.FunSuite

class PalindromeLinkedListTest extends FunSuite {

  test("single element list should be palindrome") {
    assert(PalindromeList.solve(ListNode(2)))
    assert(PalindromeList.solve(ListNode(3)))
    assert(PalindromeList.solve(ListNode(9)))
  }

  test("two element list is palindrome if both elements are the same") {
    assert(! PalindromeList.solve(ListNode(1, ListNode(2))))
    assert(PalindromeList.solve(ListNode(3, ListNode(3))))
  }

  test("even element list is palindrome if all items occur even times in symmetric pos") {
    assert(PalindromeList.solve(ListNode(1, ListNode(2, ListNode(2, ListNode(1))))))
    assert(! PalindromeList.solve(ListNode(2, ListNode(1, ListNode(2, ListNode(1))))))
  }

  test("odd element list is palindrome if all items occur even times in symmetric pos except middle") {
    assert(PalindromeList.solve(ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(1)))))))
    assert(PalindromeList.solve(ListNode(1, ListNode(2, ListNode(3, ListNode(3, ListNode(3, ListNode(2, ListNode(1)))))))))
    assert(! PalindromeList.solve(ListNode(2, ListNode(1, ListNode(3, ListNode(2, ListNode(1)))))))
  }
}
