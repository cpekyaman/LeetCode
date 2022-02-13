package com.leetcode.problems.easy

object FirstUniqueChar {
  def find(s: String): Int = {
    val firstSeenPos = Array.ofDim[Int](26)

    val base = 'a'.toInt
    for(i <- 0 until s.length) {
      val ch = s.charAt(i) - base
      // if we haven't seen char before, set its position in array
      // otherwise reset it to -1 to signify we saw it more than once
      if(firstSeenPos(ch) == 0) {
        // we use i + 1 as 0 is also valid pos and we init the pos array with defaults
        firstSeenPos(ch) = i + 1
      } else {
        firstSeenPos(ch) = -1
      }
    }

    var min = Integer.MAX_VALUE
    for(i <- firstSeenPos.indices) {
      val pos = firstSeenPos(i) - 1
      if(pos >= 0 && pos < min) {
        min = pos
      }
    }

    if(min == Integer.MAX_VALUE) -1 else min
  }
}
