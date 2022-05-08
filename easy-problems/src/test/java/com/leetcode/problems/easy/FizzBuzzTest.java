package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FizzBuzzTest extends Assertions {

    @ParameterizedTest
    @MethodSource("fizzBuzzDataSet")
    void shouldGenerateFizzBuzz(int n, List<String> answer) {
        assertThat(new FizzBuzz().solve(n)).hasSameElementsAs(answer);
    }

    static Stream<Arguments> fizzBuzzDataSet() {
        return Stream.of(Arguments.of(3, List.of("1", "2", "Fizz")),
                         Arguments.of(5, List.of("1","2","Fizz","4","Buzz")));
    }
}