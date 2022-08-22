package com.leetcode.problems.hard;

import java.util.ArrayList;
import java.util.List;

public final class Game24 {
    private static final double eps = 0.1D;

    public boolean judgePoint24(int[] cards) {
        List<Double> numbers = new ArrayList<>(cards.length);
        for(int card : cards) {
            numbers.add((double)card);
        }
        return game24(numbers);
    }

    private boolean game24(List<Double> numbers) {
        if(numbers.size()==1) {
            return Math.abs(numbers.get(0)-24) < eps;
        }

        for(int i=0; i<numbers.size(); i++) {
            for(int j=i+1; j<numbers.size(); j++) {
                List<Double> next = new ArrayList<>();
                for(int n=0; n<numbers.size(); n++) {
                    if(n != i && n != j) {
                        next.add(numbers.get(n));
                    }
                }

                for(Double d : calculate(numbers.get(i), numbers.get(j))) {
                    next.add(d);
                    if(game24(next)) {
                        return true;
                    }
                    next.remove(next.size()-1);
                }
            }
        }

        return false;
    }

    private List<Double> calculate(double a, double b) {
        List<Double> values = new ArrayList<>(6);

        values.add(a+b);
        values.add(a-b);
        values.add(b-a);
        values.add(a*b);

        if(Math.abs(b) > eps) {
            values.add(a/b);
        }
        if(Math.abs(a) > eps) {
            values.add(b/a);
        }
        return values;
    }
}
