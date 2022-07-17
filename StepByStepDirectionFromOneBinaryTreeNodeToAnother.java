/*
Problem: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
TC: O(n)
SC: O(n)
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sPath = new StringBuilder();
        StringBuilder dPath = new StringBuilder();
        
        find(root, startValue, sPath);
        find(root, destValue, dPath);
        
        sPath = sPath.reverse();
        dPath = dPath.reverse();
        
        int i = 0;
        for (i = 0; i < Math.min(sPath.length(), dPath.length()); ++i) {
            if (sPath.charAt(i) != dPath.charAt(i)) {
                break;
            }
        }
        
        return "U".repeat(sPath.length() - i) + dPath.substring(i);
    }
    
    private boolean find(TreeNode root, int target, StringBuilder path) {
        if (root == null)
            return false;
        
        if (root.val == target)
            return true;
        
        if (find(root.left, target, path)) {
            path.append("L");
            return true;
        }
        if (find(root.right, target, path)) {
            path.append("R");
            return true;
        }
        
        return false;
    }
}