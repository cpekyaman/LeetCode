package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    private static final int[] hours = new int[] {8,4,2,1};
    private static final int[] mins = new int[] {32,16,8,4,2,1};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        combine(ans, turnedOn, 0, 0, 0);

        return ans;
    }

    private void combine(List<String> ans, int on,
                         int hour, int min, int start) {

        if(on == 0) {
            ans.add(String.format("%1d:%02d", hour, min));
            return;
        }

        for(int i=start; i<hours.length + mins.length; i++) {
            if(i < hours.length && hour+hours[i] < 12) {
                combine(ans, on-1, hour+hours[i], min, i+1);
            } else if(i >= hours.length && min+mins[i-hours.length] < 60) {
                combine(ans, on-1, hour, min+mins[i-hours.length], i+1);
            }
        }
    }
}
