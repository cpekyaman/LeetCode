package com.leetcode.problems.easy

class MovingAverage(_size: Int) {
  private val queue = scala.collection.mutable.Queue[Int]()

  private var total: Long = 0

  def next(`val`: Int): Double = {
    if(queue.size == _size) {
      total -= queue.dequeue()
    }
    queue.enqueue(`val`)
    total += `val`

    scala.math.BigDecimal(total.doubleValue() / queue.size).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
