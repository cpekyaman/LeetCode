package com.leetcode.problems.medium;

public final class LongestSubstrWithAtLeastKRepeating {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        if(k <= 1) {
            return s.length();
        }

        return findLongest(s, 0, s.length()-1, k);
    }

    private int findLongest(String s, int start, int end, int k) {
        if(start > end) {
            return 0;
        }

        // calculate frequencies
        int[] freqs = new int[26];
        for(int i=start; i<=end; i++) {
            freqs[s.charAt(i)-'a']+=1;
        }

        // check if all chars occur more than k or not
        boolean match=true;
        for(int freq : freqs) {
            if(freq > 0 && freq < k) {
                match = false;
                break;
            }
        }

        // current string matches requirements, return length of it (bounds inclusive)
        if(match) {
            return end-start+1;
        }

        // if a char violates constraint, find the best result from the last split pos to i.
        // the split pos will be range start of recursive call for substring (splitPos, i-1).
        int splitPos=start, best=0;
        for(int i=start; i<=end; i++) {
            if(freqs[s.charAt(i)-'a'] < k) {
                // we only cover left side of split.
                // if more invalid chars further, valid result on right not possible on full range.
                // if not, we cover the right side of the last split after the for loop.
                best = Integer.max(best, findLongest(s, splitPos, i-1, k));
                // each time we found a violating char, move splitPos further.
                // as current char would prevent having a valid result from any recursive call.
                splitPos = i+1;
            }
        }

        // to handle last update to splitPos and cover the substring (splitPos, end).
        // this is essentially handling right side of the last split (as it is the only not covered).
        best = Integer.max(best, findLongest(s, splitPos, end, k));

        return best;
    }
}
