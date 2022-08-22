package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> roots = new HashMap<>();
        concat(root, roots);

        List<TreeNode> ans = new ArrayList<>();
        for(List<TreeNode> vals : roots.values()) {
            if(vals.size() > 1) {
                ans.add(vals.get(0));
            }
        }
        return ans;
    }

    private String concat(TreeNode node, Map<String, List<TreeNode>> roots) {
        if(node == null) {
            return null;
        }

        String str = String.format("%d-%s-%s", node.val, concat(node.left, roots), concat(node.right, roots));
        roots.computeIfAbsent(str, k -> new ArrayList<>()).add(node);
        return str;
    }
}
