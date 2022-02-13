package com.leetcode.learning.recursion

import scala.annotation.tailrec

object XToPowerN {
  def nonRecursive(x: Double, n: Int): Double = {
    val longN = n.toLong
    if(n >= 0) fastPower(x, longN) else 1.00 / fastPower(x, Math.abs(longN))
  }

  private def fastPower(x: Double, n: Long): Double = {
    if(n == 0) {
      return 1.0
    }

    val half = fastPower(x, n / 2)
    if(n % 2 == 0) half * half else half * half * x
  }

  def recursive(x: Double, n: Int): Double = {
    if(n >= 0) acc(x, 1, n) else 1.00 / acc(x, 1, Math.abs(n))
  }

  @tailrec
  private def acc(x: Double, xn: Double, n: Int): Double = {
    if(n == 0) {
      return xn
    }

    acc(x, xn * x, n - 1)
  }
}
