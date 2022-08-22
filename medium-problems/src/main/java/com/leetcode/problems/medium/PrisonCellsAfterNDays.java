package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        // cell number is limited, so does the possible states.
        // for a large n states will start repeating.
        // this map will keep which state is seen at which step.
        Map<Integer, Integer> seenStates = new HashMap<>();

        while(n > 0) {
            // once we a see a state again, it means we found the cycle period.
            // since states repeat after this, we fast forward to step closest to end.
            int bitmap = bitMap(cells);
            if(seenStates.containsKey(bitmap)) {
                // if we see a state at n=20 and see it now again at n=15, we have cycle with length 5.
                // n % 5 will move us to the step after last possible time we see this state (sort-of).
                n = n % (seenStates.get(bitmap)-n);
            } else {
                seenStates.put(bitmap, n);
            }

            // we simply calculate the next state.
            // this is either before cycle is found or the remaining steps after fast forwarding.
            if(n > 0) {
                cells = nextDay(cells);
                n--;
            }
        }
        return cells;
    }

    // since we have only 8 cells we convert 0|1 states of cells to a bitmap.
    // this bitmap will represent the state and serve as a key.
    private int bitMap(int[] cells) {
        int bits = 0;
        for(int cell : cells) {
            bits <<= 1;
            bits |= cell;
        }
        return bits;
    }

    // calculate state of next day
    private int[] nextDay(int[] cells) {
        int[] next = new int[cells.length];
        for(int i=1; i<next.length-1; i++) {
            next[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
        }
        return next;
    }
}
