package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidWordAbbreviationTest extends Assertions {

    @ParameterizedTest
    @CsvSource({
            "substitution,s10n,true", "substitution,sub4u4,true", "substitution,12,true",
            "substitution,s55n,false", "substitution,s010n,false", "substitution,s0ubstitution,false",
            "hi,hi1,false", "hi,2i,false", "hi,1,false"
    })
    void shouldDetermineIfAbbreviationIsValid(String word, String abbr, boolean result) {
        assertThat(new ValidWordAbbreviation().determine(word, abbr)).isEqualTo(result);
    }

}