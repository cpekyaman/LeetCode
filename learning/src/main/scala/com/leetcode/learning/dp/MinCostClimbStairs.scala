package com.leetcode.learning.dp

object MinCostClimbStairs {
  def climb(costs: Array[Int]): Int = {
    val n = costs.length
    if (n == 1) {
      return costs(0)
    }
    if(n == 2) {
      return Integer.min(costs(0), costs(1))
    }

    // possible starting positions, cost is 0 for them
    var costToReachPrevLast = 0
    var costToReachLast = 0

    for(i <- 2 to n) {
      val current = Integer.min(costToReachLast + costs(i - 1), costToReachPrevLast + costs(i - 2))
      costToReachPrevLast = costToReachLast
      costToReachLast = current
    }
    costToReachLast
  }

}
