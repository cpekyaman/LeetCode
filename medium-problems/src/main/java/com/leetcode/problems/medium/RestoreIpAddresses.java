package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class RestoreIpAddresses {
    public List<String> restore(String s) {
        List<String> result = new LinkedList<>();
        restoreIp(s, result, new ArrayList<>(4), 0);
        return result;
    }

    private void restoreIp(String s, List<String> result, List<String> current, int index) {
        // if the remaining digits are longer than what we can have in ip,
        // this is a wrong candidate and we return
        if(s.length()-index > (4-current.size()) * 3) {
            return;
        }

        // if the above case is not true and we have this case,
        // then we reach a valid ip.
        if(current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }

        // pick a substring starting from last position with at most 3 digits.
        // add it as a new segment if it is a valid segment value.
        // go down one level for next segment and backtrack.
        for(int i=1; i<=3 && index+i <= s.length(); i++) {
            String segment = s.substring(index, index+i);
            if(isValidIpSegment(segment)) {
                current.add(segment);
                restoreIp(s, result, current, index+i);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isValidIpSegment(String s) {
        if(s.charAt(0) == '0') {
            return s.length() == 1;
        }

        int ip = Integer.parseInt(s);
        return ip <= 255 && ip >= 1;
    }
}
