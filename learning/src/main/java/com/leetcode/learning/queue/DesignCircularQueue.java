package com.leetcode.learning.queue;

public class DesignCircularQueue {
    static final class CircularQueue {
        private final int[] queue;
        private final int capacity;
        private int front=0;
        private int rear=-1;
        private int size=0;

        public CircularQueue(int k) {
            this.queue = new int[k];
            this.capacity = k;
        }

        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return queue[front];
        }

        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return queue[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.enQueue(4));

        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        queue.deQueue();
        queue.enQueue(4);
        System.out.println(queue.Rear());
    }
}
