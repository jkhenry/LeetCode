/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        TreeNode res = new TreeNode(0);
        res.left = root;
        helper(res);
        return res.left;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        if (allZeros(root.left)) {
            root.left = null;
        } else {
            helper(root.left);
        }

        if (allZeros(root.right)) {
            root.right = null;
        } else {
            helper(root.right);
        }
    }

    private boolean allZeros(TreeNode root) {
        if (root == null) return true;

        if (root.val == 1) {
            return false;
        }

        return allZeros(root.left) && allZeros(root.right);
    }
}