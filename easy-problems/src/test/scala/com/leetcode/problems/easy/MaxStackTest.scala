package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MaxStackTest extends FunSuite {

  test("should perform stack operations") {
    // given
    val stack = new MaxStack()

    // when
    stack.push(5)
    stack.push(1)
    stack.push(5)

    // then
    assert(stack.top() == 5)
    assert(stack.popMax() == 5)
    assert(stack.top() == 1)
    assert(stack.peekMax() == 5)
    assert(stack.pop() == 1)
    assert(stack.top() == 5)
  }
}
