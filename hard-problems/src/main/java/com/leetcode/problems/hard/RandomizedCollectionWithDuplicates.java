package com.leetcode.problems.hard;

import java.util.*;

public final class RandomizedCollectionWithDuplicates {
    private final ArrayList<Integer> values;
    private final HashMap<Integer, Set<Integer>> valueIndices;

    private final Random random = new Random();

    public RandomizedCollectionWithDuplicates() {
        values = new ArrayList<>();
        valueIndices = new HashMap<>();
    }

    public boolean insert(int val) {
        valueIndices.computeIfAbsent(val, v->new LinkedHashSet<>()).add(values.size());
        values.add(val);
        return valueIndices.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!valueIndices.containsKey(val)) {
            return false;
        }

        int index = valueIndices.get(val).iterator().next();
        valueIndices.get(val).remove(index);

        int last = values.get(values.size() - 1);
        values.set(index, last);
        valueIndices.get(last).add(index);
        valueIndices.get(last).remove(values.size() - 1);

        values.remove(values.size() - 1);
        if(valueIndices.get(val).isEmpty()) {
            valueIndices.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    // "insert","insert","insert","insert","insert",
    // [1],[1],[2],[2],[2],
    //
    // "remove","remove","remove","insert","remove",
    // [1],[1],[2],[1],[2],
    //
    // "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"
    // [],[],[],[],[],[],[],[],[],[]]
    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
    }

    private static void testOne() {
        RandomizedCollectionWithDuplicates coll = new RandomizedCollectionWithDuplicates();
        coll.insert(1);
        coll.insert(1);
        coll.insert(2);
        coll.insert(2);
        coll.insert(2);

        coll.remove(1);
        coll.remove(1);
        coll.remove(2);
        coll.insert(2);
        coll.remove(1);

        coll.getRandom();
        coll.getRandom();
        coll.getRandom();
        coll.getRandom();
        coll.getRandom();
    }

    // "insert","insert","insert","insert","insert","insert",
    //[10],[10],[20],[20],[30],[30],
    //
    //"remove","remove","remove","remove"
    //[10],[10],[30],[30],
    private static void testTwo() {
        RandomizedCollectionWithDuplicates coll = new RandomizedCollectionWithDuplicates();

        coll.insert(10);
        coll.insert(10);
        coll.insert(20);
        coll.insert(20);
        coll.insert(30);
        coll.insert(30);

        coll.remove(10);
        coll.remove(10);
        coll.remove(30);
        coll.remove(30);

        coll.getRandom();
        coll.getRandom();
        coll.getRandom();
        coll.getRandom();
    }

    // "insert","insert","insert","insert","insert","insert"
    //[9],[9],[1],[1],[2],[1],
    //
    //,"remove","remove","remove","insert","remove"
    //[2],[1],[1],[9],[1]]
    private static void testThree() {
        RandomizedCollectionWithDuplicates coll = new RandomizedCollectionWithDuplicates();

        coll.insert(9);
        coll.insert(9);
        coll.insert(1);
        coll.insert(1);
        coll.insert(2);
        coll.insert(1);

        coll.remove(2);
        coll.remove(1);
        coll.remove(1);
        coll.insert(9);
        coll.remove(1);
    }
}
