package com.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class SymmetricTreeTest extends Assertions {

    @Test
    void shouldReturnTrueWhenTreeIsSymmetric() {
        // given
        SymmetricTree.TreeNode root = node(1,
                                           node(2, node(3), node(4)),
                                           node(2, node(4), node(3)));

        // when / then
        assertThat(new SymmetricTree().solve(root)).isTrue();
    }

    @Test
    void shouldReturnFalseWhenTreeIsNotSymmetric() {
        // given
        SymmetricTree.TreeNode root = node(1,
                                           node(2, node(2), null),
                                           node(2, node(2), null));

        // when / then
        assertThat(new SymmetricTree().solve(root)).isFalse();
    }

    private SymmetricTree.TreeNode node(int value) {
        return new SymmetricTree.TreeNode(value);
    }

    private SymmetricTree.TreeNode node(int value, SymmetricTree.TreeNode left, SymmetricTree.TreeNode right) {
        return new SymmetricTree.TreeNode(value, left, right);
    }
}