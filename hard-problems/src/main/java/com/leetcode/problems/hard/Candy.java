package com.leetcode.problems.hard;

import java.util.Arrays;

public final class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // each child has at least one candy.
        Arrays.fill(candies, 1);

        // set candy per child by comparing each to its left.
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i]=candies[i-1]+1;
            }
        }

        int total=candies[ratings.length-1];
        // now do the same but compare each to its right.
        // only update when you need to increase candy count of the child.
        for(int i=ratings.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i]=Integer.max(candies[i], candies[i+1]+1);
            }
            total += candies[i];
        }
        return total;
    }
}
