package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class TopKFrequentInArray {
    private final Random random = new Random();

    public int[] find(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.compute(num, (key,v) -> v == null ? 1 : v+1);
        }

        final int n = freq.size();
        int[] uniq = new int[n];
        int ui=0;
        for(Integer num : freq.keySet()) {
            uniq[ui++]=num;
        }

        quickSelect(freq, uniq, n-k, 0, n-1);
        return Arrays.copyOfRange(uniq, n-k, n);
    }

    private void quickSelect(Map<Integer, Integer> freq,
                             int[] uniq, int k,
                             int left, int right) {

        if(left == right) {
            return;
        }

        int pivot = lomuto(freq, uniq, left, right);

        if(k == pivot) {
            return;
        } else if(k < pivot) {
            quickSelect(freq, uniq, k, left, pivot-1);
        } else {
            quickSelect(freq, uniq, k, pivot+1, right);
        }
    }

    private int lomuto(Map<Integer, Integer> freq, int[] uniq, int left, int right) {
        int pivot = left + random.nextInt(right-left);
        int pfreq = freq.get(uniq[pivot]);

        swap(uniq, pivot, right);
        int store=left;
        for(int i=left; i<=right; i++) {
            if(freq.get(uniq[i]) < pfreq) {
                swap(uniq, i, store);
                store++;
            }
        }

        swap(uniq, store, right);
        return store;
    }

    private void swap(int[] uniq, int i, int j) {
        int temp = uniq[i];
        uniq[i] = uniq[j];
        uniq[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,1,1,3,73,1};

        System.out.println(Arrays.toString(new TopKFrequentInArray().find(nums, 2)));
    }
}
