package com.leetcode.problems.easy

import com.leetcode.problems.easy.DesignHashMap.MyHashMap
import org.scalatest.FunSuite

class DesignHashMapTest extends FunSuite {

  List(1,3,5,7,27,9).foreach{ in =>
    test(s"should return -1 for key $in when map is empty") {
      // given
      val map = new MyHashMap

      // when / then
      assert(map.get(in) == -1)
    }
  }

  test("should be able to find items put in the map") {
    // given
    val map = new MyHashMap

    // when
    map.put(5, 1234)
    map.put(250, 9876)

    // then
    assert(map.get(5) == 1234)
    assert(map.get(250) == 9876)
  }

  test("should be able to handle hash collisions") {
    // given
    val map = new MyHashMap

    // when
    map.put(2000, 2233)
    map.put(4000, 5678)

    // then
    assert(map.get(2000) == 2233)
    assert(map.get(4000) == 5678)
  }

  test("should be able to remove item from map") {
    // given
    val map = new MyHashMap
    map.put(5, 1234)
    map.put(250, 9876)

    // when
    map.remove(5)

    // then
    assert(map.get(5) == -1)
    assert(map.get(250) == 9876)
  }

  test("should be able to remove with hash collisions") {
    // given
    val map = new MyHashMap
    map.put(2000, 2233)
    map.put(4000, 5678)
    map.put(8000, 2121)

    // when
    map.remove(4000)

    // then
    assert(map.get(2000) == 2233)
    assert(map.get(8000) == 2121)
  }
}
