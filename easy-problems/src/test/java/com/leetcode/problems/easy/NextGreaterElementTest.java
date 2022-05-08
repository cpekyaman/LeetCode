package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NextGreaterElementTest extends Assertions {

    @Test
    void shouldBeAbleToFind() {
        // given
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        // when
        assertThat(new NextGreaterElement().find(nums1, nums2)).containsExactly(-1,3,-1);
    }

}