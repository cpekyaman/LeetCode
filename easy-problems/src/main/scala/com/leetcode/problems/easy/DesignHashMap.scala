package com.leetcode.problems.easy

object DesignHashMap {

  class MyHashMap() {
    private val bucketSize = 2000
    private val buckets = Array.ofDim[Node](bucketSize)

    def put(key: Int, value: Int): Unit = {
      val hash = bucketIndex(key)
      if(buckets(hash) == null) {
        buckets(hash) = new Node(key, value)
      } else {
        var prev: Node = null
        var head = buckets(hash)
        var found = false
        while(head != null && ! found) {
          if(head.key == key) {
            head.value = value
            found = true
          } else {
            prev = head
            head = head.next
          }
        }

        if(! found) {
          prev.next = new Node(key, value)
        }
      }
    }

    def get(key: Int): Int = {
      val hash = bucketIndex(key)
      if(buckets(hash) == null) {
        return -1
      }

      var head = buckets(hash)
      while(head != null) {
        if(head.key == key) {
          return head.value
        }
        head = head.next
      }
      -1
    }

    def remove(key: Int): Unit = {
      val hash = bucketIndex(key)
      if(buckets(hash) == null) {
        return
      }

      var prev: Node = null
      var head = buckets(hash)
      var found = false
      while(head != null && ! found) {
        if(head.key == key) {
          if(prev == null) {
            buckets(hash) = head.next
          } else {
            prev.next = head.next
          }
          found = true
        } else {
          prev = head
          head = head.next
        }
      }
    }

    private def bucketIndex(key: Int): Int = key % bucketSize

    private class Node(var key: Int, var value: Int, var next: Node = null)
  }


}
