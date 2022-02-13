package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ShortestWordDistTest extends FunSuite {

  List((Array[String]("practice", "makes", "perfect", "coding", "makes"),
         "coding", "practice", 3),
       (Array[String]("practice", "makes", "perfect", "coding", "makes"),
         "makes", "coding", 1)).foreach{ in =>

    test(s"should find distance between ${in._2} and ${in._3} as ${in._4}") {
      assert(ShortestWordDist.find(in._1, in._2, in._3) == in._4)
    }
  }
}
