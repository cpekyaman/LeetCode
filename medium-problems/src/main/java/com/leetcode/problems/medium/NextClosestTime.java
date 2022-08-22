package com.leetcode.problems.medium;

import java.util.Arrays;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        // this will keep our updated time.
        char[] nextTime = time.toCharArray();

        // we'll search this for the next possible digit for each position.
        char[] digits = new char[]{nextTime[0], nextTime[1], nextTime[3], nextTime[4]};
        Arrays.sort(digits);

        // if we find a higher digit for any position from right to left, we return the found result.
        // otherwise, we need to continue to higher order positions as lower ones simply rolled over.
        boolean foundNext = setNextGreater(nextTime, 4, digits, '9');
        if(foundNext) {
            return new String(nextTime);
        }

        foundNext = setNextGreater(nextTime, 3, digits, '5');
        if(foundNext) {
            return new String(nextTime);
        }

        // we can have 19 has hour but not 29.
        foundNext = setNextGreater(nextTime, 1, digits, nextTime[0] == '2' ? '3' : '9');
        if(foundNext) {
            return new String(nextTime);
        }

        setNextGreater(nextTime, 0, digits, '2');

        return new String(nextTime);
    }

    // find the next larger digit less than the limit (hour position can only have [0-2], for example).
    // we return true if we found a larger digit, or false if we simply rolled over to lowest possible.
    private boolean setNextGreater(char[] nextTime, int pos, char[] digits, char limit) {
        // we are at the limit, roll over.
        if(nextTime[pos] == limit) {
            nextTime[pos] = digits[0];
            return false;
        }

        boolean found = false;
        for(char c : digits) {
            if(c > limit) {
                break;
            }

            if(c > nextTime[pos]) {
                found = true;
                nextTime[pos] = c;
                break;
            }
        }

        // no higher digit available, roll over to lowest possible.
        if(! found) {
            nextTime[pos] = digits[0];
        }

        // whether we found a non-roll over digit solution.
        return found;
    }
}
