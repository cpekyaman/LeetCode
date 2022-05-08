package com.leetcode.problems.easy;

public final class AddBinary {
    public static String add(String a, String b) {
        int aptr=a.length()-1, bptr = b.length()-1;
        boolean carry = false;

        StringBuilder sum = new StringBuilder();
        while(aptr >= 0 && bptr >= 0) {
            boolean sameBit = a.charAt(aptr) == b.charAt(bptr);
            if(carry) {
                sum.append(sameBit ? '1' : '0');
                carry = b.charAt(bptr) == '1' || a.charAt(aptr) == '1';
            } else {
                sum.append(sameBit ? '0' : '1');
                carry = sameBit && a.charAt(aptr) == '1';
            }

            aptr--;
            bptr--;
        }

        if(aptr >= 0 || bptr >= 0) {
            String str = (aptr >= 0 ? a : b);
            int ptr = (aptr >= 0 ? aptr : bptr);

            while(ptr >= 0) {
                if(carry) {
                    boolean bitSet = str.charAt(ptr) == '1';
                    sum.append(bitSet ? '0' : '1');
                    carry = bitSet;
                } else {
                    sum.append(str.charAt(ptr));
                }
                ptr--;
            }
        }

        if(carry) {
            sum.append('1');
        }

        return sum.reverse().toString();
    }
}
