package com.leetcode.problems.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class SmallestRangeFromKLists {
    public static int[] find(List<List<Integer>> nums) {
        PriorityQueue<ListItem> items = new PriorityQueue<>(Comparator.comparingInt(li -> nums.get(li.listIndex).get(li.elementIndex)));

        int start=0, end=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++) {
            if(nums.get(i) != null) {
                items.add(new ListItem(i, 0));
                max = Integer.max(max, nums.get(i).get(0));
            }
        }

        while(!items.isEmpty() && items.size() == nums.size()) {
            ListItem current = items.poll();
            if(end - start > max - nums.get(current.listIndex).get(current.elementIndex)) {
                start = nums.get(current.listIndex).get(current.elementIndex);
                end = max;
            }
            current.nextElement();
            if(nums.get(current.listIndex).size() > current.elementIndex) {
                items.add(current);
                max = Integer.max(max, nums.get(current.listIndex).get(current.elementIndex));
            }
        }
        return new int[]{start, end};
    }

    private static final class ListItem {
        private int listIndex;
        private int elementIndex;

        ListItem(int listIndex, int elementIndex) {
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        void nextElement() {
            this.elementIndex++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SmallestRangeFromKLists.find(List.of(List.of(4,10,15,24,26),
                                                                                List.of(0,9,12,20),
                                                                                List.of(5,18,22,30)))));
    }
}
