package com.leetcode.problems.easy

import org.scalatest.FunSuite

class FirstUniqueCharTest extends FunSuite {

  List(("leetcode", 0), ("loveleetcode", 2), ("aabb", -1)).foreach{in =>
    test(s"first unique char in ${in._1} is at ${in._2}") {
      assert(FirstUniqueChar.find(in._1) == in._2)
    }
  }
}
