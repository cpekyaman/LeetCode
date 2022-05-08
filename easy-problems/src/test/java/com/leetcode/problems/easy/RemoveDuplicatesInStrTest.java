package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RemoveDuplicatesInStrTest extends Assertions {

    @ParameterizedTest
    @CsvSource({"abbaca,ca", "azxxzy,ay"})
    void shouldRemoveDuplicatesInStr(String in, String out) {
        assertThat(new RemoveDuplicatesInStr().remove(in)).isEqualTo(out);
    }

}