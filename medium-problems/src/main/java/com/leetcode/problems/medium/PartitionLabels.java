package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // find the last occurrence of each char in the string.
        // this will help determine the ending point of each partition.
        int[] pos = new int[26];
        for(int i=0; i<s.length(); i++) {
            pos[s.charAt(i)-'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        // for each i we determine if that position can be the end of a partition.
        // if charAt(i)=a and lastPos(a)=i+y, current partition including i extends to at least i+y.
        // and the next possible partition starts from i+y+1.
        int start=0, end=0;
        for(int i=0; i<s.length(); i++) {
            // whether current partition needs to be extended for current char.
            // or it is already long enough.
            end = Integer.max(end, pos[s.charAt(i)-'a']);
            // as of i, we find that partition can end at i.
            if(end == i) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
