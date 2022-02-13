package com.leetcode.learning.recursion

object Search2DMatrix {

  def search(matrix: Array[Array[Int]], target: Int): Boolean = {
    if(matrix.length == 0) {
      return false
    }

    val m = matrix.length
    val n = matrix(0).length

    search(matrix, target, 0, 0, m-1, n-1)
  }

  private def search(matrix: Array[Array[Int]], target: Int,
                     top: Int, left: Int, bottom: Int, right: Int): Boolean = {

    // invalid bounds
    if(bottom < top || right < left) {
      return false
    }

    // target is out of bounds
    if(target > matrix(bottom)(right) || target < matrix(top)(left)) {
      return false
    }

    // finding pivot where matrix(row)(col) >= target
    val pcol = left + (right - left) / 2
    var prow = top
    while(prow <= bottom && matrix(prow)(pcol) <= target) {
      if(matrix(prow)(pcol) == target) {
        return true
      }
      prow += 1
    }

    // search bottom-left and top-right
    search(matrix, target, prow, left, bottom , pcol - 1) ||
      search(matrix, target, top, pcol + 1, prow - 1 , right)
  }
}
