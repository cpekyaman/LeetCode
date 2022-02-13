package com.leetcode.learning.recursion

object Fibonacci {
  def fib(n: Int): Int = {
    fibLoop(n, 0, 1)
  }

  private def fibLoop(n: Int, a: Int, b: Int): Int = {
    if(n == 0) a else fibLoop(n - 1, b, a + b)
  }
}
