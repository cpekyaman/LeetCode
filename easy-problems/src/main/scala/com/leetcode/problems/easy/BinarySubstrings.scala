package com.leetcode.problems.easy

object BinarySubstrings {

  def count(s: String): Int = {
    var charOfSequence = s(0)

    var expectedLen = 1
    // initial char sequence will always be for expectedLen
    var runningLen = 0

    var count = 0

    // if current char is same as we see previously we are in the sequence.
    // we reset the previous as current and increment count for each char switch.
    // we count char switches + any sequences with "current len" = "previous char sequence len"
    for{i <- 1 until s.length} {
      if(s(i) == charOfSequence) {
        if(runningLen >= 1) {
          runningLen += 1
          if(runningLen <= expectedLen) {
            count += 1
          }
        } else {
          expectedLen += 1
        }
      } else {
        // always non zero after initial sequence switch
        if(runningLen > 0) {
          expectedLen = runningLen
        }
        count += 1
        runningLen = 1
        charOfSequence = s(i)
      }
    }

    count
  }
}
