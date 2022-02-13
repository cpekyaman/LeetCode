package com.leetcode.learning.recursion

object QuickSort {
  def sort(array: Array[Int]): Array[Int] = {
    sort(array, 0, array.length - 1)
    array
  }

  private def sort(array: Array[Int], lo: Int, hi: Int): Unit = {
    if(hi <= lo) {
      return
    }

    val pivot = partition(array, lo, hi)

    sort(array, lo, pivot - 1)
    sort(array, pivot + 1, hi)
  }

  private def partition(array: Array[Int], lo: Int, hi: Int): Int = {
    var left = lo
    var right = hi

    val pivot = array(lo)
    while(left < right) {
      while(left < hi && array(left) <= pivot) {
        left += 1
      }
      while(right > lo && array(right) > pivot) {
        right -= 1
      }

      if(left < right) {
        swap(array, left, right)
      }
    }

    swap(array, lo, right)
    right
  }

  private def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }
}
