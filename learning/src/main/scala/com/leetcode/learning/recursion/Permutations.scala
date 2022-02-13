package com.leetcode.learning.recursion

object Permutations {
  import scala.collection.mutable

  private var nums: Array[Int] = _
  private var n: Int = 0
  private var permutations: List[List[Int]] = List[List[Int]]()

  def generate(nums: Array[Int]): List[List[Int]] = {
    this.nums = nums
    this.n = nums.length
    permutations = List[List[Int]]()

    generateRecursive(0, List[Int](), mutable.Set[Int]())
    permutations
  }

  private def generateRecursive(i: Int, perm: List[Int], used: mutable.Set[Int]): Unit = {
    if(perm.length == nums.length) {
      permutations = perm :: permutations
      return
    }

    // we start from i in i...n and roll over to 0...i
    for(j <- i until n+i) {
      val currIdx = j % n
      val currNum = nums(currIdx)
      if(! used(currNum)) {
        used += currNum
        // we build the permutation in reverse as we prepend
        // it does not matter as we both have a,b,c and c,b,a as perms
        // and order of permutations don't matter
        generateRecursive(currIdx+1, currNum +: perm, used)
        used -= currNum
      }
    }
  }
}
