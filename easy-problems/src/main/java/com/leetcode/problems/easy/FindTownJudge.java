package com.leetcode.problems.easy;

public final class FindTownJudge {
    public static int find(int n, int[][] trust) {
        int[] trusted = new int[n+1];
        int[] trusting = new int[n+1];
        for(int[] t : trust) {
            trusted[t[1]]+=1;
            trusting[t[0]]+=1;
        }

        int judge=-1;
        for(int i=1;i<=n;i++) {
            int t = trusted[i];
            if(trusted[i] == n-1 && trusting[i]==0) {
                judge = i;
            }
        }
        return judge;
    }
}
