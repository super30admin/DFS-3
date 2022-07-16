/*
Problem: https://leetcode.com/problems/distribute-coins-in-binary-tree/
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        distribute(root);
        return moves;
    }
    
    private int distribute(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = distribute(root.left);
        int right = distribute(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right;
    }
}