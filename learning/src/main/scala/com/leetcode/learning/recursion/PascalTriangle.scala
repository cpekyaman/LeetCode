package com.leetcode.learning.recursion

object PascalTriangle {
  def getRow(rowIndex: Int): List[Int] = {
    if(rowIndex == 0) {
      return List(1)
    }
    if(rowIndex == 1) {
      return List(1,1)
    }

    val highRow = getRow(rowIndex - 1)
    (0 to rowIndex).map(i => element(i, highRow)).toList
  }

  private def element(i: Int, row: List[Int]): Int = {
    if(i == 0 || i == row.size) 1 else row(i) + row(i - 1)
  }
}
