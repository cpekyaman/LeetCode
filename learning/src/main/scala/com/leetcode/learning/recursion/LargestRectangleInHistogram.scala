package com.leetcode.learning.recursion

object LargestRectangleInHistogram {
  private var heights: Array[Int] = _

  def find(heights: Array[Int]): Int = {
    this.heights = heights
    recursiveMaxArea(0, heights.length - 1)
    iterativeMaxArea()
  }

  import scala.collection.mutable
  private def iterativeMaxArea(): Int = {
    val stack = mutable.Stack[Int]()

    stack.push(-1)

    // store each item as long as height increases (max possible area for each of them increases)
    // get and calculate each items max possible area when the height is decreasing
    var maxArea = 0
    for(i <- heights.indices) {
      // when current item indicates decreasing height,
      // we calculate respective max possible areas of each item we encountered so far.
      // where item i is the right bound for all of them
      while(stack.top != -1 && heights(stack.top) >= heights(i)) {
        val currH = heights(stack.pop())
        val width = i - stack.top - 1
        maxArea = Integer.max(maxArea, currH * width)
      }
      stack.push(i)
    }

    while(stack.top != -1) {
      val currH = heights(stack.pop())
      val width = heights.length - stack.top - 1
      maxArea = Integer.max(maxArea, currH * width)
    }

    maxArea
  }

  // for each sub array we find minHeight and area of the array for that height
  // then we do the same for subarray left of minItem and right of min item
  // and we return the max area of the three results
  private def recursiveMaxArea(lo: Int, hi: Int): Int = {
    if(lo > hi) {
      return 0
    }

    var minIdx = lo
    for(i <- lo to hi) {
      if(heights(i) < heights(minIdx)) {
        minIdx = i
      }
    }

    Integer.max(heights(minIdx) * (hi - lo + 1),
                Integer.max(recursiveMaxArea(lo, minIdx - 1), recursiveMaxArea(minIdx + 1, hi)))
  }
}
