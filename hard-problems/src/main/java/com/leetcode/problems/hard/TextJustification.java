package com.leetcode.problems.hard;

import java.util.ArrayList;
import java.util.List;

public final class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        List<StringBuilder> current = new ArrayList<>();
        int currLen=0;
        for(String word : words) {
            // add new word to current line until total length exceeds max.
            // totalLen=currLen + len(word) + count(current + 1) spaces
            if(currLen + word.length() + current.size() > maxWidth) {
                ans.add(justify(current, currLen, maxWidth));

                currLen=0;
                current.clear();
            }

            currLen += word.length();
            current.add(new StringBuilder().append(word));
        }

        // last line is simply a space separated string + remaining spaces
        if(current.size() > 0) {
            StringBuilder lastLine = new StringBuilder().append(String.join(" ", current));
            int spaces = maxWidth - lastLine.length();
            for(int i=0; i<spaces; i++) {
                lastLine.append(' ');
            }
            ans.add(lastLine.toString());
        }

        return ans;
    }

    // can be optimized by finding total spaces and dividing them per slot.
    // and adding excess spaces with another loop.
    private static String justify(List<StringBuilder> current, int currLen, int maxWidth) {
        // add a space after each word except the last one.
        // sz takes into account a list of size length 1.
        int i=0, len=currLen, sz=Integer.max(1, current.size()-1);
        while(len < maxWidth) {
            current.get(i % sz).append(' ');
            len+=1;
            i++;
        }

        return String.join("",current);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        System.out.println(TextJustification.fullJustify(words, 16));
    }
}
