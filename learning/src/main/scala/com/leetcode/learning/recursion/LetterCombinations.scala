package com.leetcode.learning.recursion

object LetterCombinations {
  import scala.collection.mutable.ListBuffer

  private var digits: String = _
  private var n:Int = _
  private val combinations: ListBuffer[String] = ListBuffer[String]()

  private val lettersOfDigit: Map[Char, String] = Map('2' -> "abc", '3' -> "def", '4' -> "ghi", '5' -> "jkl",
                                                      '6' -> "mno", '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz")

  def find(digits: String): List[String] = {
    this.digits = digits
    this.n = digits.length
    this.combinations.clear()

    if(n == 0) {
      List.empty[String]
    } else {
      combine(0, List[Char]())
      combinations.toList
    }
  }

  private def combine(current: Int, combination: List[Char]): Unit = {
    if(combination.length == n) {
      combinations += combination.reverse.mkString("")
      return
    }

    // no explicit backtracking, we simply pass a new list head to recursive call
    for(c <- lettersOfDigit(digits.charAt(current))) {
      combine(current+1, c :: combination)
    }
  }
}
