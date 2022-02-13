package com.leetcode.problems.easy

object LoggerRateLimiter {

  class Logger() {
    private val logsPresent = scala.collection.mutable.Set[String]()
    private val logStream = scala.collection.mutable.Queue[LogMessage]()

    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      val removed = logStream.dequeueAll(lm => timestamp - lm.timestamp >= 10)
      removed.foreach(lm => logsPresent.remove(lm.message))

      if(! logsPresent.contains(message)) {
        logsPresent.add(message)
        logStream.enqueue(new LogMessage(timestamp, message))
        true
      } else {
        false
      }
    }

    private class LogMessage(val timestamp: Int, val message: String)
  }
}
