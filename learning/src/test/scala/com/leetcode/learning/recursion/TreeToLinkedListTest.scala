package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class TreeToLinkedListTest extends FunSuite {

  test("should convert tree to list") {
    // given
    val root = Node(4, Node(2,
                            Node(1),
                            Node(3)),
                    Node(5))

    // when
    val head = TreeToLinkedList.convert(root)

    // then
    verify(head, List(1,2,3,4,5))
  }

  test("should convert another tree to list") {
    // given
    val root = Node(8, Node(4,
                            Node(2),
                            Node(6,
                                 Node(5),
                                 Node(7))),
                    Node(9))

    // when
    val head = TreeToLinkedList.convert(root)

    // then
    verify(head, List(2,4,5,6,7,8,9))
  }

  private def verify(head: Node, expected: List[Int]): Unit = {
    var node = head.right
    var list = List[Int](head.value)
    while(node != null && node != head) {
      list = node.value :: list
      node = node.right
    }
    assert(list.reverse == expected)
  }
}
