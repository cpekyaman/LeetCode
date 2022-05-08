package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KthMissingPositiveTest extends Assertions {

    @Test
    void shouldFindKthMissingPositive() {
        // given
        int[] array = new int[]{2,3,4,7,11};
        int k = 5;

        // when / then
        assertThat(new KthMissingPositive().find(array, k)).isEqualTo(9);
    }

}