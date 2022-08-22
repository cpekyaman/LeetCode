package com.leetcode.problems.hard;

public class ReadNGivenRead4 {

    static final class ReaderN {
        private final Reader4 reader;

        private int readPos;
        private int readCount;
        private final char[] temp;

        public ReaderN(Reader4 reader) {
            this.reader = reader;
            this.temp = new char[4];
        }

        public int read(char[] buf, int n) {
            int bufPos = 0;

            while(bufPos < n) {
                if(readPos == 0) {
                    readCount=reader.read4(temp);
                }
                if(readCount == 0) {
                    break;
                }

                while(readPos < readCount && bufPos < n) {
                    buf[bufPos++]=temp[readPos++];
                }

                if(readPos >= readCount) {
                    readPos = 0;
                }
            }

            return bufPos;
        }
    }

    public interface Reader4 {
        int read4(char[] buf4);
    }
}
