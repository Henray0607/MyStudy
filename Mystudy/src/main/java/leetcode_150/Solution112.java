package leetcode_150;

import model.TreeNode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        return traverse(root, targetSum, sum);
    }

    public boolean traverse(TreeNode node, int targetSum, int sum) {
        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            return targetSum == sum;
        }
        if (node.left != null && traverse(node.left, targetSum, sum)) {
            return true;
        }
        if (node.right != null && traverse(node.right, targetSum, sum)) {
            return true;
        }
        return false;
    }
}
