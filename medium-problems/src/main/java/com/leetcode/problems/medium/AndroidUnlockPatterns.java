package com.leetcode.problems.medium;

public class AndroidUnlockPatterns {
    private static final int[][] rules = getTraverseRules();

    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];

        int count = 0;
        // in terms of navigation patterns and rules,
        // 1,3,7,9 and 2,4,6,8 form groups due to their symmetry, and 5 is a group by itself.
        // for the first two, we calculate patterns for one num in group and multiply by 4.
        count += dfs(1, 1, 0, m, n, visited) * 4;
        count += dfs(2, 1, 0, m, n, visited) * 4;
        count += dfs(5, 1, 0, m, n, visited);

        return count;
    }

    private int dfs(int curr, int len, int count, int m, int n, boolean[] visited) {
        // don't start counting until we reach the min number of keys.
        if(len >= m) {
            count++;
        }

        // we reached the number of keys limit.
        if(len == n) {
            return count;
        }

        // each num is unique in unlock pattern.
        visited[curr] = true;

        // try next possible keys.
        for(int next=1; next<=9; next++) {
            // don't try next if it is already visited,
            // or we didn't visit the key between curr and next.
            if(!visited[next] && (rules[curr][next]==0 || visited[rules[curr][next]])) {
                count = dfs(next, len+1, count, m, n, visited);
            }
        }

        visited[curr] = false;
        return count;
    }

    // these are the rules we need to use when jumping from key to key.
    private static int[][] getTraverseRules() {
        int[][] rules = new int[10][10];

        rules[1][3]=2;
        rules[3][1]=2;

        rules[1][7]=4;
        rules[7][1]=4;

        rules[3][9]=6;
        rules[9][3]=6;

        rules[7][9]=8;
        rules[9][7]=8;

        rules[2][8]=5;
        rules[8][2]=5;
        rules[4][6]=5;
        rules[6][4]=5;
        rules[1][9]=5;
        rules[9][1]=5;
        rules[3][7]=5;
        rules[7][3]=5;

        return rules;
    }
}
