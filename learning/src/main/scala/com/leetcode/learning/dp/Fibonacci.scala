package com.leetcode.learning.dp

object Fibonacci {
  def bottomUp(n: Int): Int = {
    val tab = Array.ofDim[Int](n + 1)
    tab(0) = 0
    tab(1) = 1

    for(i <- 2 to n) {
      tab(i) = tab(i - 2) + tab(i - 1)
    }

    tab(n)
  }

  import scala.collection.mutable.{ Map => MMap}
  def topDown(n: Int): Int = {
    fibLoop(n, MMap[Int, Int]())
  }

  def fibLoop(n: Int, mem: MMap[Int, Int]): Int = {
    if(n <= 1) {
      return n
    }

    mem.getOrElseUpdate(n, fibLoop(n - 2, mem) + fibLoop(n - 1, mem))
  }
}
