package com.leetcode.problems.medium;

public final class DesignLinkedList {
    private static class MyLinkedList {
        // these are marker/sentinel nodes and they don't change
        private final Node head;
        private final Node tail;

        private int size;

        public MyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);

            head.next = tail;
            tail.previous = head;
        }

        public int get(int index) {
            if(index < 0 || index >= size) {
                return -1;
            }
            return find(index).val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = head.next;
            head.next.previous = node;
            node.previous = head;
            head.next = node;

            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            node.previous = tail.previous;
            tail.previous.next = node;
            node.next = tail;
            tail.previous = node;

            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index < 0 || index > size) {
                return;
            }

            if(index == size) {
                addAtTail(val);
                return;
            }

            Node node = find(index);
            Node added = new Node(val);

            added.next = node;
            added.previous = node.previous;
            node.previous.next = added;
            node.previous = added;

            size++;
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) {
                return;
            }

            Node node = find(index);
            node.previous.next = node.next;
            node.next.previous = node.previous;

            node.next = null;
            node.previous = null;

            size--;
        }

        private Node find(int index) {
            Node node = head.next;
            int pos=0;
            while(node != null && pos < index) {
                node = node.next;
                pos++;
            }
            return node;
        }

        private static final class Node {
            private int val;
            private Node previous;
            private Node next;

            Node(int val) {
                this.val = val;
            }
        }
    }

    // ["MyLinkedList","addAtHead","addAtHead","addAtHead","get","get","addAtIndex","deleteAtIndex","addAtHead","addAtIndex","addAtHead","addAtTail"]
    //[[],[5],[7],[0],[2],[3],[1,3],[2],[9],[3,9],[4],[5]]
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(5);
        list.addAtHead(7);
        list.addAtHead(0);
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        list.addAtIndex(1,3);
        list.deleteAtIndex(2);
        list.addAtHead(9);
        list.addAtIndex(3, 9);
        list.addAtHead(4);
        list.addAtTail(5);
    }
}
