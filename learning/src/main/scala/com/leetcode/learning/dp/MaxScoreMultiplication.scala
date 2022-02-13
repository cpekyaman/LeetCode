package com.leetcode.learning.dp

object MaxScoreMultiplication {
  def topDown(nums: Array[Int], mul: Array[Int]): Int = {
    val mem = Array.fill[Int](mul.length, mul.length) { -1 }
    topDown(nums, mul, mem, 0, 0)
  }

  private def topDown(nums: Array[Int], mul: Array[Int], mem: Array[Array[Int]], i: Int, left: Int): Int = {
    if(i == mul.length) {
      return 0
    }

    val m = mul(i)
    if(mem(i)(left) == -1) {
      val dpi = Integer.max(m * nums(left) + topDown(nums, mul, mem, i + 1, left + 1),
                            m * nums(nums.length - 1 - (i - left)) + topDown(nums, mul, mem, i + 1, left))

      mem(i)(left) = dpi
    }

    mem(i)(left)
  }

  def bottomUp(nums: Array[Int], mul: Array[Int]): Int = {
    val n = nums.length
    val m = mul.length

    val dp = Array.ofDim[Int](m + 1, m + 1)
    for(i <- m - 1 to 0 by -1) {
      for(left <- i to 0 by -1) {
        val mi = mul(i)
        val right = n - 1 - (i - left)

        val dpi = Integer.max(mi * nums(left) + dp(i + 1)(left + 1), mi * nums(right) + dp(i + 1)(left))
        dp(i)(left) = dpi
      }
    }

    dp(0)(0)
  }
}
