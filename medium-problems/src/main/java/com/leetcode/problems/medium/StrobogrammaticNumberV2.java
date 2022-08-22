package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberV2 {
    private static final Map<Character, Character> pairs = Map.of('0', '0', '1', '1',
                                                                  '6', '9', '8', '8', '9', '6');

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        findRecurse(result, new char[n], 0, n-1);
        return result;
    }

    // we add symmetric pairs at each end given by left and right bounds.
    // then we move down one level to repeat.
    // we add the number found when we reach one of the base cases.
    private void findRecurse(List<String> result, char[] current, int left, int right) {
        // this base condition happens when n is even.
        if(left > right) {
            result.add(new String(current));
            return;
        }

        // this base condition happens when n is odd.
        // center element should be a symmetric digit such as 8.
        if(left == right) {
            for(Map.Entry<Character, Character> pair : pairs.entrySet()) {
                if(pair.getKey() == pair.getValue()) {
                    current[left] = pair.getKey();
                    result.add(new String(current));
                }
            }
            return;
        }

        // for each level of left/right, we add pairs to each end and recurse one more level.
        for(Map.Entry<Character, Character> pair : pairs.entrySet()) {
            if(pair.getKey() != '0' || left > 0) {
                current[left] = pair.getKey();
                current[right] = pair.getValue();
                findRecurse(result, current, left+1, right-1);
            }
        }
    }
}
