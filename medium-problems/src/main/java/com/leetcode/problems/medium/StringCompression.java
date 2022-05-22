package com.leetcode.problems.medium;

public final class StringCompression {
    public int compress(char[] chars) {
        int store=0,len=0;
        char prev = '\u0000';
        for(int i=0; i<chars.length; i++) {
            if(chars[i] != prev) {
                if(prev != '\u0000') {
                    store=compressChar(chars, store, len, prev);
                }
                prev = chars[i];
                len=1;
            } else {
                len++;
            }
        }

        return compressChar(chars, store, len, prev);
    }

    private int compressChar(char[] chars, int store, int len, char prev) {
        chars[store++]=prev;
        if(len > 1) {
            if(len < 10) {
                chars[store++]=(char)('0'+len);
            } else {
                for(char c : Integer.toString(len).toCharArray()) {
                    chars[store++]=c;
                }
            }
        }
        return store;
    }
}
