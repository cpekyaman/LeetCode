package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AddBinaryTest extends Assertions {

    @ParameterizedTest
    @CsvSource({"1010,1011,10101"})
    void shouldAddStringsAsBinary(String a, String b, String sum) {
        assertThat(AddBinary.add(a,b)).isEqualTo(sum);
    }

}