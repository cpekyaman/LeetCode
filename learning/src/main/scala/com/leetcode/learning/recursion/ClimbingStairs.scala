package com.leetcode.learning.recursion

object ClimbingStairs {
  private val mem: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map()

  def climbStairs(n: Int): Int = {
    if(n <= 2) {
      return n
    }

    mem.getOrElseUpdate(n, climbStairs(n - 1) + climbStairs(n - 2))
  }
}
