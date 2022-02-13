package com.leetcode.problems.easy

import org.scalatest.FunSuite

class MissingRangesTest extends FunSuite {

  List((Array[Int](0,1,3,50,75), 0, 99,
         List[String]("2","4->49","51->74","76->99")),
       (Array[Int](-1), -1, -1, List.empty[String]),
       (Array[Int](), 1, 4, List("1->4"))).foreach{ in =>

    test(s"should find missing ranges in ${in._1.mkString(",")}") {
      assert(MissingRanges.find(in._1, in._2, in._3).equals(in._4))
    }
  }
}
