package com.leetcode.problems.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    // using de Bruijn sequence concept
    public String crackSafe(int n, int k) {
        // we'll generate a string that is of length k^n.
        // we need to have all combinations of k length alphabet with length n.
        int total = (int) Math.pow(k, n);

        // this will have the result pwd which will have k^n combinations as subsequences.
        // the shortest possible length for such a string is k^n + n - 1.
        char[] pwd = new char[total + n - 1];
        Arrays.fill(pwd, 0, n, '0');

        Set<String> visited = new HashSet<>();
        visited.add(new String(pwd, 0, n));

        generatePwd(visited, pwd, n, total, n, k);

        return new String(pwd);
    }

    private boolean generatePwd(Set<String> visited, char[] pwd, int idx, int total, int n, int k) {
        // we generated k^n distinct combinations.
        // pwd array contains all of these as its subsequences and has length k^n now.
        if(visited.size() == total) {
            return true;
        }

        // reached end of the pwd without hitting base condition, will backtrack
        if(idx == pwd.length) {
            return false;
        }

        // at each idx:
        // - we get last n-1 chars as the last combination.
        // - and append a digit to form next sequence of length n.
        // - move on with the next idx.
        // - backtrack if the path we choose didn't produce all combinations.
        for(int i=0; i<k; i++) {
            pwd[idx]=(char)('0' + i);
            String newCombination = new String(pwd, idx-n+1, n);
            if(visited.add(newCombination)) {
                if(generatePwd(visited, pwd, idx+1, total, n, k)) {
                    return true;
                }
                visited.remove(newCombination);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CrackingTheSafe cts = new CrackingTheSafe();
        System.out.println(cts.crackSafe(1,2));
        System.out.println(cts.crackSafe(2,2));
    }
}
