package com.leetcode.problems.easy

import org.scalatest.FunSuite

class StrobogrammaticNumberTest extends FunSuite {

  List(("69", true), ("88", true), ("962", false),
       ("986", true), ("375", false), ("0", true),
       ("1", true), ("5", false), ("8968", true),
       ("6", false)).foreach{ in =>

    test(s"${in._1} is strobogrammatic = ${in._2}") {
      assert(StrobogrammaticNumber.determine(in._1) == in._2)
    }
  }
}
