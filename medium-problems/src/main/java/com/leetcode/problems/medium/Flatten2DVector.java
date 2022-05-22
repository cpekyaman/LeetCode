package com.leetcode.problems.medium;

import java.util.NoSuchElementException;

public final class Flatten2DVector {
    public static final class Vector2D {
        private final int[][] vec;
        private int arrPtr=0;
        private int valPtr=0;

        public Vector2D(int[][] vec) {
            this.vec = vec;
        }

        public int next() {
            if(! hasNext()) {
                throw new NoSuchElementException();
            }
            return vec[arrPtr][valPtr++];
        }

        public boolean hasNext() {
            while(arrPtr < vec.length && valPtr >= vec[arrPtr].length) {
                valPtr=0;
                arrPtr++;
            }
            return arrPtr < vec.length && valPtr < vec[arrPtr].length;
        }
    }
}
