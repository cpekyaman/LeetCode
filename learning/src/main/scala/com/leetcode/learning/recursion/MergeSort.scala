package com.leetcode.learning.recursion

object MergeSort {

  def sort(array: Array[Int]): Array[Int] = {
    topDown(array)
    array
  }

  private def topDown(array: Array[Int]): Unit = {
    topDown(array, 0, array.length - 1)
  }

  private def topDown(array: Array[Int], lo: Int, hi: Int): Unit = {
    if(hi <= lo) {
      return
    }

    val mid = lo + (hi - lo) / 2
    topDown(array, lo, mid)
    topDown(array, mid+1, hi)
    merge(array, lo, mid, hi)
  }

  private def merge(array: Array[Int], lo: Int, mid: Int, hi: Int): Unit = {
    // temp array for range to merge
    val temp = Array.tabulate[Int](hi - lo + 1) { i => array(lo+i) }

    // end pointers scaled to temp
    val lpEnd = mid - lo
    val rpEnd = temp.length - 1

    // left and right pointers scaled to temp
    var lp = 0
    var rp = mid+1-lo
    for(k <- lo to hi) {
      if(lp > lpEnd) {
        array(k) = temp(rp)
        rp+=1
      } else if(rp > rpEnd) {
        array(k) = temp(lp)
        lp+=1
      } else if(temp(lp) < temp(rp)) {
        array(k) = temp(lp)
        lp+=1
      } else {
        array(k) = temp(rp)
        rp+=1
      }
    }
  }
}
