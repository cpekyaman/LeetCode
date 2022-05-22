package com.leetcode.problems.medium;

public final class InorderSuccessor {
    private boolean found;
    private TreeNode succ;

    public TreeNode findInBST(TreeNode root, TreeNode p) {
        while(root.val != p.val) {
            if(p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if(p.right == null) {
            return succ;
        } else {
            root = p.right;
            while(root.left != null) {
                root = root.left;
            }
            return root;
        }
    }

    public TreeNode find(TreeNode root, TreeNode p) {
        succ = null;
        found = false;
        inorder(root, p);
        return succ;
    }

    private void inorder(TreeNode node, TreeNode p) {
        if(node == null || succ != null) {
            return;
        }

        inorder(node.left, p);

        if(found) {
            if(succ == null) {
                succ = node;
            }
            return;
        }
        found = node == p;

        inorder(node.right, p);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, null);

        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3, two, four);

        TreeNode six = new TreeNode(6);
        TreeNode root = new TreeNode(5, three, six);

        System.out.println(new InorderSuccessor().find(root, one));
    }
}
