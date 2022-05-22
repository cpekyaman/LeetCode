package com.leetcode.problems.medium;

public final class FindTheCelebrity {
    public int findCelebrity(int n) {

        // pick a candidate, if candidate knows someone, pick the new candidate.
        // at the end we eliminated candidates that know at least someone.
        int celebrity=0;
        for(int i=1; i<n; i++) {
            if(knows(celebrity, i)) {
                celebrity = i;
            }
        }

        // if our candidate knows someone with i < candidateIndex, they are not celebrity
        for(int i=0; i<celebrity; i++) {
            if(knows(celebrity, i)) {
                celebrity=-1;
                break;
            }
        }

        // if there is anyone that does not know our candidate, it is not celebrity
        if(celebrity >= 0) {
            for(int i=0; i<n; i++) {
                if(celebrity != i && !knows(i, celebrity)) {
                    celebrity=-1;
                    break;
                }
            }
        }

        return celebrity;
    }

    private boolean knows(int a, int b) {
        return false;
    }
}
