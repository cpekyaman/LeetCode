package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxUnitsOnATruckTest extends Assertions {

    @ParameterizedTest
    @MethodSource("maxUnitDataSet")
    void shouldFindMaxUnitsPossible(int[][] boxTypes, int truckSize, int maxUnits) {
        assertThat(new MaxUnitsOnATruck().solve(boxTypes, truckSize)).isEqualTo(maxUnits);
    }

    static Stream<Arguments> maxUnitDataSet() {
        return Stream.of(Arguments.of(new int[][]{ {1,3}, {2,2}, {3,1} }, 4, 8),
                         Arguments.of(new int[][]{ {5,10}, {2,5}, {4,7}, {3,9} }, 10, 91));
    }
}