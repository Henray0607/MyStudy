package leetcode_150;

import model.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = Integer.MIN_VALUE;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDepth = Math.max(maxDepth, Math.max(left, right) + 1);
        return maxDepth;
    }
}
