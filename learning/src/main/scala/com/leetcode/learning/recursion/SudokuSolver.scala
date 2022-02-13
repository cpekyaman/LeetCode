package com.leetcode.learning.recursion

object SudokuSolver {
  import scala.collection.mutable

  private val boxSize = 3
  private val boardSize = boxSize * boxSize

  private var boxes: Array[mutable.BitSet] = _
  private var rows: Array[mutable.BitSet] = _
  private var cols: Array[mutable.BitSet] = _

  private var board: Array[Array[Char]] = _

  private var solved = false

  def solve(board: Array[Array[Char]]): Unit = {
    this.board = board
    this.solved = false

    boxes = Array.fill[mutable.BitSet](9){ mutable.BitSet() }
    rows = Array.fill[mutable.BitSet](9){ mutable.BitSet() }
    cols = Array.fill[mutable.BitSet](9){ mutable.BitSet() }

    initialState()
    placeDigits(0, 0)
  }

  private def initialState(): Unit = {
    for(r <- board.indices) {
      for(c <- board(0).indices) {
        if(board(r)(c) != '.') {
          val num = board(r)(c).getNumericValue
          placeDigit(num, r, c)
        }
      }
    }
  }

  private def findBox(row: Int, col: Int): Int = (row / boxSize) * boxSize + col / boxSize

  private def placeDigits(row: Int, col: Int): Unit = {
    if (row > boardSize - 1) {
      solved = true
      return
    }

    if(board(row)(col) == '.') {
      for(d <- 1 to 9) {
        if(canPlaceDigit(d, row, col)) {
          placeDigit(d, row, col)
          placeDigits(if(col == boardSize - 1) row + 1 else row,
                      if(col == boardSize - 1) 0 else col + 1)

          if(! solved) {
            removeDigit(d, row, col)
          }
        }
      }
    } else {
      placeDigits(if(col == boardSize - 1) row + 1 else row,
                  if(col == boardSize - 1) 0 else col + 1)
    }
  }

  private def canPlaceDigit(d: Int, row: Int, col: Int): Boolean = {
    ! (rows(row)(d) || cols(col)(d) || boxes(findBox(row,col))(d))
  }

  private def placeDigit(num: Int, r: Int, c: Int): Unit = {
    boxes(findBox(r,c)).add(num)
    rows(r).add(num)
    cols(c).add(num)

    board(r)(c) = ('0' + num).toChar
  }

  private def removeDigit(num: Int, r: Int, c: Int): Unit = {
    boxes(findBox(r,c)).remove(num)
    rows(r).remove(num)
    cols(c).remove(num)

    board(r)(c) = '.'
  }
}
