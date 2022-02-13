package com.leetcode.learning.recursion

object GenerateParenthesis {
  import scala.collection.mutable.ListBuffer

  def generate(n: Int): List[String] = {
    val result = combinations(n).toList
    println(result)
    result
  }

  private def combinations(n: Int): ListBuffer[String] = {
    val dp = Array.fill[ListBuffer[String]](n + 1) { ListBuffer[String]() }

    dp(0) += ""
    dp(1) += "()"

    for(i <- 2 to n) {
      for(j <- 0 until i) {
        // a=dp(j) combinations for n=j
        // b=dp(i-j-1) combinations for n=i-j-1
        // a+b = combinations for n=i-1
        // combinations for i = ("(" + a + ")" + b) for each (a,b)
        dp(i) ++= combination(dp, j, i-j-1)
      }
    }

    dp(n)
  }

  private def combination(dp: Array[ListBuffer[String]], i: Int, j: Int): ListBuffer[String] = {
    val comb = ListBuffer[String]()
    // l and r are already valid combinations of lower sizes and l + r = i-1
    for(l <- dp(i)) {
      for(r <- dp(j)) {
        comb += ("(" + l + ")" + r)
      }
    }

    comb
  }
}
