package com.leetcode.problems.easy

object ReorderLogData {
  def reorder(logs: Array[String]): Array[String] = {
    for(i <- 0 until logs.length) {
      for(j <- i until 0 by -1) {
        val compare = compareStr(logs, j, j - 1)
        if(compare < 0) {
          swap(logs, j, j - 1)
        }
      }
    }
    logs
  }

  private def compareStr(logs: Array[String], posOne: Int, posTwo: Int): Int = {
    val str1 = logs(posOne)
    val str2 = logs(posTwo)

    val idPos1 = str1.indexOf(' ')
    val content1 = str1.substring(idPos1 + 1)

    val idPos2 = str2.indexOf(' ')
    val content2 = str2.substring(idPos2 + 1)

    val isFirstStrLetter = Character.isLetter(content1.charAt(0))
    val isSecondStrLetter = Character.isLetter(content2.charAt(0))

    if(isFirstStrLetter && ! isSecondStrLetter) {
      -1
    } else if(! isFirstStrLetter && isSecondStrLetter) {
      1
    } else if (! isFirstStrLetter && ! isSecondStrLetter) {
      posOne.compareTo(posTwo)
    } else {
      val contentCompare = content1.compareTo(content2)
      if(contentCompare != 0) contentCompare else str1.substring(0, idPos1).compareTo(str2.substring(0, idPos2))
    }
  }

  private def swap(logs: Array[String], i: Int, j: Int): Unit = {
    val temp = logs(j)
    logs(j) = logs(i)
    logs(i) = temp
  }
}
