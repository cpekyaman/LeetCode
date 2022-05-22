package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class ConstructBinaryTreeFromPreorderAndInorder {
    private int rootPos;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootPos=0;
        Map<Integer, Integer> inorderpos = new HashMap<>(inorder.length);
        for(int i=0; i<inorder.length; i++) {
            inorderpos.put(inorder[i], i);
        }
        return build(preorder, inorderpos, 0, preorder.length-1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> inorderpos, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[rootPos++];
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorderpos, start, inorderpos.get(rootVal)-1);
        root.right = build(preorder, inorderpos, inorderpos.get(rootVal)+1, end);
        return root;
    }
}
