package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorder {
    private int currentPos;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currentPos = postorder.length-1;

        Map<Integer, Integer> inorderPos = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }

        return build(postorder, inorderPos, 0, postorder.length-1);
    }

    private TreeNode build(int[] postorder, Map<Integer, Integer> inorderPos, int left, int right) {
        if(left > right) {
            return null;
        }

        int nextVal = postorder[currentPos--];
        int nodePos = inorderPos.get(nextVal);

        TreeNode node = new TreeNode(nextVal);
        node.right = build(postorder, inorderPos, nodePos+1, right);
        node.left = build(postorder, inorderPos, left, nodePos-1);
        return node;
    }
}
