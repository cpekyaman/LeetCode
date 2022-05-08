package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntersectionOfTwoArraysTest extends Assertions {

    @ParameterizedTest
    @MethodSource("twoArrayDataSet")
    void shouldFindTheIntersectionOfArrays(int[] nums1, int[] nums2, int[] intersection) {
        assertThat(new IntersectionOfTwoArrays().find(nums1, nums2)).containsExactlyInAnyOrder(intersection);
    }

    static Stream<Arguments> twoArrayDataSet() {
        return Stream.of(
                Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9}),
                Arguments.of(new int[]{1,2,4,2,3}, new int[]{2,2}, new int[]{2}));
    }
}