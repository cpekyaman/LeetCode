package com.leetcode.problems.medium;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        // pointers that will move from one '.' position to the next
        int p1=0, p2=0;

        while(p1 < version1.length() || p2 < version2.length()) {
            Chunk c1 = parsePart(version1, p1);
            Chunk c2 = parsePart(version2, p2);

            // update pointers
            p1 = c1.pos;
            p2 = c2.pos;

            // if a chunk is not equal, return comparison value
            int comp = Integer.compare(c1.version, c2.version);
            if(comp != 0) {
                return comp;
            }
        }

        // if we reach here, they are equal
        return 0;
    }

    private Chunk parsePart(String version, int start) {
        // we parsed all the parts, return 0 as revision
        if(start >= version.length()) {
            return new Chunk(start, 0);
        }

        // parse the revision between current pos and the next '.' or end of string
        int end = version.indexOf('.', start);
        if(end > 0) {
            // end+1 is important to start next search after current '.' position
            return new Chunk(end+1, Integer.parseInt(version.substring(start, end)));
        } else {
            return new Chunk(version.length(), Integer.parseInt(version.substring(start)));
        }
    }

    private static final class Chunk {
        private int pos;
        private int version;

        Chunk(int pos, int version) {
            this.pos = pos;
            this.version = version;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.01", "1.001"));
    }
}
