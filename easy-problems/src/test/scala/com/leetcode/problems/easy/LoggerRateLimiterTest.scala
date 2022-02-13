package com.leetcode.problems.easy

import org.scalatest.FunSuite

class LoggerRateLimiterTest extends FunSuite {

  test("should rate limit logs") {
    // given
    val logger = new LoggerRateLimiter.Logger()

    // when / then
    assert(logger.shouldPrintMessage(1, "foo"))
    assert(logger.shouldPrintMessage(2, "bar"))
    assert(! logger.shouldPrintMessage(3, "foo"))
    assert(! logger.shouldPrintMessage(8, "bar"))
    assert(! logger.shouldPrintMessage(10, "foo"))
    assert(logger.shouldPrintMessage(11, "foo"))
  }
}
