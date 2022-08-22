package com.leetcode.learning.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MinStackTest extends Assertions {

    @Test
    void shouldPerformStackOperationInConstantTime() {
        // given
        var stack = new MinStack();

        // when
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        // then
        assertThat(stack.getMin()).isEqualTo(-3);

        // and
        stack.pop();
        // then
        assertThat(stack.top()).isEqualTo(0);

        // and
        stack.pop();
        // then
        assertThat(stack.getMin()).isEqualTo(-2);
    }

}