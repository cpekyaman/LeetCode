package com.leetcode.problems.medium;

import java.util.*;

public final class RandomizedSet {
    private final Map<Integer, Integer> valueIndices;
    private final List<Integer> values;
    private final Random rand;

    public RandomizedSet() {
        this.valueIndices = new HashMap<>();
        this.values = new ArrayList<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        if(valueIndices.containsKey(val)) {
            return false;
        }
        values.add(val);
        valueIndices.put(val, values.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(! valueIndices.containsKey(val)) {
            return false;
        }

        int index = valueIndices.remove(val);
        int last = values.get(values.size()-1);
        if(val != last) {
            values.set(index, last);
            valueIndices.put(last, index);
        }
        values.remove(values.size()-1);

        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
