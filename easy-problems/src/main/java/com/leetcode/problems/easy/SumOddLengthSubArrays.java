package com.leetcode.problems.easy;

public final class SumOddLengthSubArrays {
    // we can also use contribution of each element and add those:
    // res += ((i + 1) * (n - i) + 1) / 2 * A[i];
    // (i + 1) * (n - i) = k = total num of subarrays that contain A[i]
    // and (k+1)/2 number of odd length subarrays.
    public static int sumOddLengthSubarrays(int[] arr) {
        // calculating prefix sums to make it easy for further logic.
        // so that sumArray(i,j) will simply be sums[j]-sums[i].
        int[] sums = new int[arr.length+1];
        for(int i=1; i<=arr.length; i++) {
            sums[i] = sums[i-1] + arr[i-1];
        }

        int ans=0;
        // starting from each index i, we get the sum of array (j-i) for each j(+=2).
        // length of subarrays go as 1,3,5,7 etc. and sum(j-i)=prefixSum[j]-prefixSum[i].
        for(int left=0; left<arr.length; left++) {
            for(int right=left+1; right <= arr.length; right+=2) {
                ans += sums[right]-sums[left];
            }
        }

        return ans;
    }
}
