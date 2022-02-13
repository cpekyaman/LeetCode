package com.leetcode.learning.dp

import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("bottomUp should calculate fibonacci") {
    assert(Fibonacci.bottomUp(2) == 1)
    assert(Fibonacci.bottomUp(3) == 2)
    assert(Fibonacci.bottomUp(4) == 3)
    assert(Fibonacci.bottomUp(5) == 5)
  }

  test("topDown should calculate fibonacci") {
    assert(Fibonacci.topDown(2) == 1)
    assert(Fibonacci.topDown(3) == 2)
    assert(Fibonacci.topDown(4) == 3)
    assert(Fibonacci.topDown(5) == 5)
  }
}
