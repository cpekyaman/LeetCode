package com.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ImplementQueueWithStacks {
    static final class MyQueue {
        private final Deque<Integer> s1;
        private final Deque<Integer> s2;

        private int front;

        public MyQueue() {
            this.s1 = new ArrayDeque<>();
            this.s2 = new ArrayDeque<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            transfer();
            return s2.pop();
        }

        public int peek() {
            transfer();
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        private void transfer() {
            if(s2.isEmpty()) {
                while(! s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }
}
