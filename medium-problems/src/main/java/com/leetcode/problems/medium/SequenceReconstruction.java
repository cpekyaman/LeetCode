package com.leetcode.problems.medium;

import java.util.*;

public final class SequenceReconstruction {
    public boolean canConstruct(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            numIndices.put(nums[i], i);
        }

        Set<String> pairsSeen = new HashSet<>();
        for(List<Integer> seq : sequences) {
            for(int i=0; i<seq.size(); i++) {
                if(! numIndices.containsKey(seq.get(i))) {
                    return false;
                }

                if(i > 0) {
                    // each pair of nums in each seq should preserve relative ordering.
                    if(numIndices.get(seq.get(i-1)) > numIndices.get(seq.get(i))) {
                        return false;
                    }

                    pairsSeen.add(seq.get(i-1) + "->" + seq.get(i));
                }
            }
        }

        // in order to have nums as unique super-sequence, all num pairs should be accounted for.
        // otherwise, those particular numbers can have multiple orderings in multiple super-sequences.
        for(int i=1; i<nums.length; i++) {
            if(! pairsSeen.contains(nums[i-1] + "->" + nums[i])) {
                return false;
            }
        }

        return true;
    }
}
