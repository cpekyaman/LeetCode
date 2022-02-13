package com.leetcode.learning.recursion

object Combinations {
  import scala.collection.mutable.{ListBuffer => MList}
  private var n: Int = _
  private var k: Int = _

  private val combinations = MList[List[Int]]()

  def find(n: Int, k: Int): List[List[Int]] = {
    this.n = n
    this.k = k

    combinations.clear()

    combineNumbers(1, List[Int]())
    combinations.toList
  }

  private def combineNumbers(currNum: Int, currCombination: List[Int]): Unit = {
    if(currCombination.size == k) {
      combinations += currCombination.reverse
      return
    }

    // not explicitly backtracking as +: creates a new list head (but not a completely new list)
    for(i <- currNum to n) {
      combineNumbers(i + 1, i +: currCombination)
    }
  }
}
