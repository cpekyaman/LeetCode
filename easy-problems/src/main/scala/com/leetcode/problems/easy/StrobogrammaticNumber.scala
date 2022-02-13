package com.leetcode.problems.easy


object StrobogrammaticNumber {
  private val flipPairs = Map[Char, Char]('6' -> '9', '9' -> '6',
                                          '8' -> '8', '0' -> '0', '1' -> '1')

  def determine(num: String): Boolean = {
    if(num.length <= 1) {
      return isFlipPair(num.charAt(0), num.charAt(0))
    }

    determineAtPos(num, 0, num.length-1)
  }

  @scala.annotation.tailrec
  private def determineAtPos(num: String, left: Int, right: Int): Boolean = {
    if(left == right) {
      val lastChar = num.charAt(left)
      return isFlipPair(lastChar, lastChar)
    }

    if(left > right) {
      return true
    }

    isFlipPair(num.charAt(left), num.charAt(right)) && determineAtPos(num, left+1, right-1)
  }

  private def isFlipPair(ch: Char, other: Char): Boolean = {
    flipPairs.contains(ch) && flipPairs(ch) == other
  }
}
