package com.leetcode.problems.easy

import org.scalatest.FunSuite

class ReadNCharsWithRead4Test extends FunSuite {

  List(("abc", 4, 3, "abc".toCharArray),
       ("abcde", 5, 5, "abcde".toCharArray),
       ("abcdABCD1234", 12, 12, "abcdABCD1234".toCharArray),
       ("abcdefgh", 4, 4, Array[Char]('a', 'b', 'c', 'd'))).foreach{ in =>
    test(s"should read requested amount of chars for ${in._1}") {
      // given
      val buf = Array.ofDim[Char](in._2)

      // when
      ReadNCharsWithRead4.setFile(in._1)
      val cnt = ReadNCharsWithRead4.read(buf, in._2)

      // then
      assert(cnt == in._3)
      assert(buf.sameElements(in._4))
    }
  }
}
