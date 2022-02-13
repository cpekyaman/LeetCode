package com.leetcode.problems.easy

object ShortestWordDist {

  def find(wordsDict: Array[String], word1: String, word2: String): Int = {
    val n = wordsDict.length

    var posOne = -1
    var posTwo = -1
    var minDist = Integer.MAX_VALUE

    for(i <- 0 until n if minDist > 1) {
      if(wordsDict(i).equals(word1)) {
        if(posTwo >= 0) {
          minDist = Integer.min(minDist, Math.abs(posTwo-i))
        }
        posOne = i
      }

      if(wordsDict(i).equals(word2)) {
        if(posOne >= 0) {
          minDist = Integer.min(minDist, Math.abs(posOne-i))
        }
        posTwo = i
      }
    }

    minDist
  }
}
