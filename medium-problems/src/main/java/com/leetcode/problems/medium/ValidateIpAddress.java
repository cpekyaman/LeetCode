package com.leetcode.problems.medium;

public final class ValidateIpAddress {
    private static final String NOT_IP = "Neither";

    public String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length()==0) {
            return NOT_IP;
        }

        if(queryIP.indexOf('.') >= 0) {
            return isValidIpv4(queryIP);
        }

        if(queryIP.indexOf(':') >= 0) {
            return isValidIpv6(queryIP);
        }

        return NOT_IP;
    }

    private String isValidIpv4(String ip) {
        String[] segments = ip.split("\\.", -1);
        if(segments.length != 4) {
            return NOT_IP;
        }

        for(String segment : segments) {
            if(! isValidIpV4Segment(segment)) {
                return NOT_IP;
            }
        }

        return "IPv4";
    }

    private boolean isValidIpV4Segment(String segment) {
        if(segment.length() == 0 || segment.length() > 3) {
            return false;
        }

        if(segment.charAt(0) == '0' && segment.length() > 1) {
            return false;
        }

        for (char ch : segment.toCharArray()) {
            if (! Character.isDigit(ch)) {
                return false;
            }
        }

        int val = Integer.parseInt(segment);
        if(val < 0 || val > 255) {
            return false;
        }

        return true;
    }

    private String isValidIpv6(String ip) {
        String[] segments = ip.split(":", -1);
        if(segments.length != 8) {
            return NOT_IP;
        }

        for(String segment : segments) {
            if(! isValidIpV6Segment(segment)) {
                return NOT_IP;
            }
        }

        return "IPv6";
    }

    private boolean isValidIpV6Segment(String segment) {
        if(segment.length() < 1 || segment.length() > 4) {
            return false;
        }

        for(char c : segment.toCharArray()) {
            if("0123456789abcdefABCDEF".indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIpAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(new ValidateIpAddress().validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334:12"));
    }
}
