package com.leetcode.learning.dp

object MinimumDifficultySchedule {
  def solve(jobDiff: Array[Int], days: Int): Int = {
    bottomUp(jobDiff, days)
    //topDown(jobDiff, days)
  }

  private def bottomUp(jobDiff: Array[Int], days: Int): Int = {
    val n = jobDiff.length
    if(n < days) {
      return -1
    }

    val dp = Array.fill[Int](n, days + 1){Int.MaxValue}

    // base case: last day you need to schedule all remaining jobs for each job position i
    dp(n-1)(days) = jobDiff(n-1)
    for(i <- n-2 to 0 by -1) {
      dp(i)(days) = Integer.max(dp(i+1)(days), jobDiff(i))
    }

    for(d <- days-1 until 0 by -1) {
      for(i <- d-1 until (n - (days - d))) {
        var hardest = 0
        for(j <- i until (jobDiff.length - (days - d))) {
          hardest = Integer.max(hardest, jobDiff(j))
          dp(i)(d) = Integer.min(dp(i)(d), hardest + dp(j + 1)(d + 1))
        }
      }
    }

    dp(0)(1)
  }

  private def topDown(jobDiff: Array[Int], days: Int): Int = {
    val n = jobDiff.length
    if(n < days) {
      return -1
    }

    val mem = Array.fill[Int](n, days + 1){-1}
    val hardestJobs = hardestJobsArray(jobDiff)

    topDown(jobDiff, days, 0, 1, mem, hardestJobs)
  }

  private def hardestJobsArray(jobDiff: Array[Int]): Array[Int] = {
    val n = jobDiff.length

    val hardestJobAfter = Array.ofDim[Int](n)
    var hardest = 0
    for(i <- n-1 to 0 by -1) {
      hardest = Integer.max(hardest, jobDiff(i))
      hardestJobAfter(i) = hardest
    }

    hardestJobAfter
  }

  private def topDown(jobDiff: Array[Int], days: Int, i: Int, d: Int,
                      mem: Array[Array[Int]], hardestJobs: Array[Int]): Int = {

    // on the last day we only need the difficulty of hardest job that remains
    if(d == days) {
      return hardestJobs(i)
    }

    if(mem(i)(d) == -1) {
      var hardest = 0
      var best = Int.MaxValue
      for(j <- i until (jobDiff.length - (days - d))) {
        hardest = Integer.max(hardest, jobDiff(j))
        best = Integer.min(best, hardest + topDown(jobDiff, days, j+1, d+1, mem, hardestJobs))
      }
      mem(i)(d) = best
    }

    mem(i)(d)
  }
}
