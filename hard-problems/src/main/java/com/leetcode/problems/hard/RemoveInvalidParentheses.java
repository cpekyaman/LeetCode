package com.leetcode.problems.hard;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Queue<StrItem> candidates = new ArrayDeque<>();

        candidates.offer(new StrItem(s, 0));
        visited.add(s);

        while(! candidates.isEmpty()) {
            // since we do bfs, once we have items in ans, the next level cannot be smaller
            if(ans.size() > 0) {
                break;
            }

            int sz = candidates.size();

            for(int i=0; i<sz; i++) {
                StrItem curr = candidates.poll();
                String currStr = curr.str;

                // the curr is already valid, no need to move one level further
                if(isValid(currStr)) {
                    ans.add(currStr);
                } else if(ans.isEmpty()) {
                    for(int c=curr.idx; c<currStr.length(); c++) {
                        char ch = currStr.charAt(c);
                        // remove the current char and add it as a candidate.
                        // we skip the current char if it is the same as previous as the result would be the same.
                        if(ch == '(' || ch == ')' && (c == curr.idx || ch != currStr.charAt(c-1))) {
                            String next = currStr.substring(0,c) + currStr.substring(c+1);
                            if(! visited.contains(next)) {
                                visited.add(next);
                                candidates.offer(new StrItem(next, c));
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int count=0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count==0;
    }

    private static final class StrItem {
        private final String str;
        private final int idx;

        StrItem(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }
}
