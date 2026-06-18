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
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        // Start recursion with the smallest possible integer value
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    public void dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return;
        }

        // If the current node value is >= maxVal, it's a "good" node
        if (node.val >= maxVal) {
            goodNodes++;
            // Update maxVal for the path to the children
            maxVal = node.val;
        }

        dfs(node.left, maxVal);
        dfs(node.right, maxVal);
    }
}
