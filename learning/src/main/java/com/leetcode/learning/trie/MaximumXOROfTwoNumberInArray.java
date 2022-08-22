package com.leetcode.learning.trie;

public class MaximumXOROfTwoNumberInArray {
    public static int findMaximumXOR(int[] nums) {
        // find maximum of the numbers
        int max=0;
        for(int num : nums) {
            max = Integer.max(max, num);
        }

        // determine the max bit length and bitmask for left padding
        int bitLen = Integer.toBinaryString(max).length();
        int bitmask = 1 << bitLen;

        // build binary string representations of numbers
        String[] bitStrings = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            // bitmask application is for left padding,
            // and substring is to remove leftmost 1 from mask
            bitStrings[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }

        // build the trie
        Node root = new Node();
        for(String bitString : bitStrings) {
            Node curr = root;
            for(char c : bitString.toCharArray()) {
                if(curr.children[c-'0']==null) {
                    curr.children[c-'0']=new Node();
                }
                curr = curr.children[c-'0'];
            }
        }

        // search for max possible xor length for each number.
        // and update global max after each result.
        int maxXor=0;
        for(String bitString : bitStrings) {
            Node curr = root;
            int currXor = 0;
            for(char c : bitString.toCharArray()) {
                int bit = c-'0';
                // if we find an opposite bit, we descend into opposite number.
                // otherwise, we continue with number represented by bitStr.
                if(curr.children[1-bit] != null) {
                    currXor = (currXor << 1) | 1;
                    curr = curr.children[1-bit];
                } else {
                    currXor = currXor << 1;
                    curr = curr.children[bit];
                }
            }
            maxXor = Integer.max(maxXor, currXor);
        }
        return maxXor;
    }

    private static final class Node {
        private char value;
        private final Node[] children;

        Node() {
            // each child is a binary node of 0 or 1
            this.children = new Node[2];
        }
    }
}
