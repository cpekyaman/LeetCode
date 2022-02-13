package com.leetcode.problems.easy

object ReformatDate {
  private val monthNameToNum = Map[String, String]("Jan" -> "01", "Feb" -> "02", "Mar" -> "03", "Apr" -> "04",
                                                   "May" -> "05", "Jun" -> "06", "Jul" -> "07", "Aug" -> "08",
                                                   "Sep" -> "09", "Oct" -> "10", "Nov" -> "11", "Dec" -> "12")

  def format(date: String): String = {
    val dateTokens = date.split(" ")

    val day = dateTokens(0).substring(0, dateTokens(0).length - 2)
    dateTokens(2) + "-" + monthNameToNum(dateTokens(1)) + "-" + (if(day.length == 1) "0" else "") + day
  }
}
