package com.leetcode.problems.medium;

import java.util.Arrays;

public class ThreeSumMulti {
    public static int count(int[] arr, int target) {
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.sort(arr);

        long count=0;
        for(int i=0; i<arr.length-2; i++) {
            int j=i+1, k=arr.length-1, t=target-arr[i];
            while(j < k) {
                int sum = arr[j] + arr[k];
                if(sum > t) {
                    k--;
                } else if(sum < t) {
                    j++;
                } else if(arr[j]==arr[k]) {
                    count += (k-j+1) * (k-j) / 2;
                    break;
                } else {
                    int jc=1, kc=1;
                    while(j+1 < k && arr[j+1]==arr[j]) {
                        jc++;
                        j++;
                    }

                    while(k-1 > j && arr[k-1]==arr[k]) {
                        kc++;
                        k--;
                    }
                    count += jc * kc;
                    j++;
                    k--;
                }
            }
            count = count % mod;
        }

        return (int)count;
    }

    public static void main(String[] args) {
        System.out.println(ThreeSumMulti.count(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
