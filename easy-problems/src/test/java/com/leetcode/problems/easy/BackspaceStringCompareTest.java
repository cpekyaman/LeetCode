package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BackspaceStringCompareTest extends Assertions {

    @ParameterizedTest
    @CsvSource({"ab#c,ad#c,true", "ab##,c#d#,true", "bbbextm,bbb#extm,false", "bxj##tw,bxj###tw,false"})
    void shouldCompareStrings(String s, String t, boolean result) {
        assertThat(BackspaceStringCompare.compare(s, t)).isEqualTo(result);
    }

}