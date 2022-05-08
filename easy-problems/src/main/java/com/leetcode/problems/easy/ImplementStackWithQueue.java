package com.leetcode.problems.easy;

import java.util.Deque;
import java.util.LinkedList;

public final class ImplementStackWithQueue {
    public static final class MyStack {
        private Deque<Integer> queue;
        private Deque<Integer> staging;
        private int top;

        public MyStack() {
            queue = new LinkedList<>();
            staging = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        public int pop() {
            int oldTop = this.top;
            while(queue.size() > 1) {
                this.top = queue.poll();
                staging.offer(this.top);
            }

            queue.remove();
            swap();
            return oldTop;
        }

        public int top() {
            return this.top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }

        private void swap() {
            Deque<Integer> temp = queue;
            queue = staging;
            staging = temp;
        }
    }
}
