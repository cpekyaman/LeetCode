package com.leetcode.learning.recursion

import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("should return base cases correctly") {
    assert(Fibonacci.fib(0) == 0)
    assert(Fibonacci.fib(1) == 1)
  }

  test("should calculate nth fibonacci") {
    assert(Fibonacci.fib(4) == 3)
    assert(Fibonacci.fib(5) == 5)
    assert(Fibonacci.fib(6) == 8)
  }
}
