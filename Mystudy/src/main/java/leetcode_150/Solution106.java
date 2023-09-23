package leetcode_150;

import model.TreeNode;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int index = 0;
        int rootVal = postorder[postEnd];
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftLen = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}
