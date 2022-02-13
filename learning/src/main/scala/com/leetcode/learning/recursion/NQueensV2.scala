package com.leetcode.learning.recursion

import scala.collection.mutable

object NQueensV2 {
  private val queens = mutable.Set[Cell]()
  private var size: Int = 0

  def solve(n: Int): Int = {
    size = n
    queens.clear()
    placeQueens(0)
  }

  private def placeQueens(row: Int): Int = {
    if(row == size) {
      return 1
    }

    var count = 0
    for(col <- 0 until size) {
      val cell = Cell(row, col)
      if(isCellUsable(cell)) {
        queens.add(cell)
        count += placeQueens(row + 1)
        queens.remove(cell)
      }
    }

    count
  }

  private def isCellUsable(c: Cell): Boolean = !queens.exists(q => q.isInCoverage(c))

  private case class Cell(row: Int, col: Int) {
    val diagonal: Int = row - col
    val antiDiagonal: Int = row + col

    def isInCoverage(target: Cell): Boolean = {
      target.row == this.row ||
        target.col == this.col ||
        target.diagonal == this.diagonal ||
        target.antiDiagonal == this.antiDiagonal
    }
  }
}
