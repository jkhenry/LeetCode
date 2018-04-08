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
    public void recoverTree(TreeNode root) {
        // Morris inorder traversal
        TreeNode pre = null , first = null, second = null, temp;
        while (root != null) {
            if (root.left == null) {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre; second = root;
                    } else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            } else {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else if (temp.right == root) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre; second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                }
            }
        }
        // swap two node values;
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}