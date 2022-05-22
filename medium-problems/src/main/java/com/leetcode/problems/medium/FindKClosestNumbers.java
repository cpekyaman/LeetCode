package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class FindKClosestNumbers {
    private int k;
    private int x;
    private int[] arr;
    private int pivot;

    public List<Integer> find(int[] arr, int k, int x) {
        this.arr = arr;
        this.k = k;
        this.x = x;
        this.pivot = 0;

        findPivot(0, arr.length-1);

        return findKClosest();
    }

    private void findPivot(int low, int high) {
        if(low > high) {
            return;
        }

        int mid = low + (high-low) / 2;
        if(arr[mid] == x) {
            this.pivot = mid;
        } else {
            if(Math.abs(arr[mid]-x) < Math.abs(arr[pivot]-x)) {
                this.pivot = mid;
            }

            if(arr[mid] > x) {
                findPivot(low, mid-1);
            } else {
                findPivot(mid+1, high);
            }
        }
    }

    private List<Integer> findKClosest() {
        int left=pivot, right=pivot+1;
        while(right - left - 1 < k && left >= 0 && right <= arr.length-1) {
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)) {
                left--;
            } else {
                right++;
            }
        }

        while(right - left - 1 < k && left >= 0) {
            left--;
        }
        while(right - left - 1 < k && right <= arr.length-1) {
            right++;
        }

        return fillResult(left, right);
    }

    private List<Integer> fillResult(int left, int right) {
        List<Integer> result = new ArrayList<>(k);
        for(int i=left+1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // [0,0,1,2,3,3,4,7,7,8]
    //3
    //5
    //
    public static void main(String[] args) {
        System.out.println(new FindKClosestNumbers().find(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(new FindKClosestNumbers().find(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
    }
}
