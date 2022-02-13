package com.leetcode.learning.recursion

object SkylineProblem {
  import scala.collection.mutable.ListBuffer
  private var buildings: Array[Array[Int]] = _
  private val points: ListBuffer[List[Int]] = ListBuffer()

  def solve(buildings: Array[Array[Int]]): List[List[Int]] = {
    this.buildings = buildings
    this.points.clear()

    points.toList
  }

}
