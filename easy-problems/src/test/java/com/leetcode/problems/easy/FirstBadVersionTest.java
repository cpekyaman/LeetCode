package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstBadVersionTest extends Assertions {

    @ParameterizedTest
    @CsvSource({ "5,4", "1,1", "6,3", "7,2", "5,1" })
    void shouldFindFirstBadVersion(int n, int badVersion) {
        // given
        FirstBadVersion fbv = new FirstBadVersion();

        // when
        fbv.setBadVersion(badVersion);

        // then
        assertThat(fbv.find(n)).isEqualTo(badVersion);
    }

}