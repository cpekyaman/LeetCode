package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // we will apply replacements from lower index to larger
        List<Repl> repl = new ArrayList<>(indices.length);
        for(int i=0; i<indices.length; i++) {
            repl.add(new Repl(indices[i], sources[i], targets[i]));
        }
        repl.sort(Comparator.comparingInt(r -> r.index));

        StringBuilder result = new StringBuilder();
        int mainPtr=0;
        // for each repl, we append chars of S that are before repl index.
        // and we optionally append the repl.target if we find a match.
        for(Repl r : repl) {
            // check if there is match for current repl
            int sp = r.index, rp=0;
            while(sp < s.length() && rp < r.src.length() && s.charAt(sp) == r.src.charAt(rp)) {
                sp++;
                rp++;
            }

            // we add the part of S between our mainPtr and current repl.
            if(mainPtr < r.index) {
                result.append(s, mainPtr, r.index);
                mainPtr=r.index;
            }
            // we add the target of current repl if there is a match.
            if(rp == r.src.length()) {
                result.append(r.target);
                // since we replaced r.src, skip mainPtr to sp (r.index+r.src.len).
                mainPtr=sp;
            }
        }

        // since we use r.index from repl list as upper limit in the loop,
        // we may have some remaining chars at the end of s that are not processed.
        if(mainPtr < s.length()) {
            result.append(s, mainPtr, s.length());
        }

        return result.toString();
    }

    private static final class Repl {
        private final int index;
        private final String src;
        private final String target;

        Repl(int index, String src, String target) {
            this.index = index;
            this.src = src;
            this.target = target;
        }
    }
}
