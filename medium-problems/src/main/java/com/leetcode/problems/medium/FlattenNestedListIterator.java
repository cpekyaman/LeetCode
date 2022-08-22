package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public final class FlattenNestedListIterator {
    public static class NestedIterator implements Iterator<Integer> {
        private final Deque<List<NestedInteger>> list;
        private final Deque<Integer> index;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = new ArrayDeque<>();
            this.index = new ArrayDeque<>();

            this.list.push(nestedList);
            this.index.push(0);
        }

        @Override
        public Integer next() {
            if(! hasNext()) {
                return null;
            }

            return get();
        }

        @Override
        public boolean hasNext() {
            // we check the current item of current list.
            // we push a new list until the current item is an integer.
            while(! index.isEmpty()) {
                // doing some cleanup, removing lists that consumed all of their items.
                if(index.peek() >= list.peek().size()) {
                    index.pop();
                    list.pop();
                    continue;
                }

                NestedInteger next = list.peek().get(index.peek());
                if (next.isInteger()) {
                    break;
                }

                // current element is also a list, we'll continue from its elements
                list.push(next.getList());
                // first update the index of the current list
                index.push(index.pop()+1);
                // starting with a new list that we just pushed above
                index.push(0);
            }

            return ! index.isEmpty();
        }

        private Integer get() {
            int idx = index.pop();
            index.push(idx + 1);
            return list.peek().get(idx).getInteger();
        }
    }

    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
