package com.leetcode.learning.dp

import org.scalatest.FunSuite

class NumWaysToDecodeTest extends FunSuite {

  test("should determine ways to decode") {
    assert(NumWaysToDecode.solve("023") == 0)
    assert(NumWaysToDecode.solve("1") == 1)
    assert(NumWaysToDecode.solve("12") == 2)
    assert(NumWaysToDecode.solve("909") == 0)
    assert(NumWaysToDecode.solve("11106") == 2)
    assert(NumWaysToDecode.solve("2125") == 5)
  }
}
