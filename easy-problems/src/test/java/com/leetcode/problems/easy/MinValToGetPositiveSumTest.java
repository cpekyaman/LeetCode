package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinValToGetPositiveSumTest extends Assertions {

    @ParameterizedTest
    @MethodSource("minStartDataSet")
    void shouldFindMinStartValue(int[] nums, int startVal) {
        assertThat(new MinValToGetPositiveSum().solve(nums)).isEqualTo(startVal);
    }

    static Stream<Arguments> minStartDataSet() {
        return Stream.of(Arguments.of(new int[]{1,2}, 1),
                         Arguments.of(new int[]{-3,2,-3,4,2}, 5));
    }
}