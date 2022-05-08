package com.leetcode.problems.easy;

public final class FirstBadVersion {
    private int badVersion;

    public int find(int n) {
        return findBadVersion(0, n-1);
    }

    private int findBadVersion(int lo, int hi) {
        if(hi < lo) {
            return lo;
        }

        int mid = lo + (hi - lo) / 2;
        if(isBadVersion(mid)) {
            return findBadVersion(lo, mid-1);
        } else {
            return findBadVersion(mid+1, hi);
        }
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }
}
