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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Queue<TreeNode> cq = new LinkedList<>();
            List<Integer> levelResult = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                levelResult.add(node.val);

                if (node.left != null)
                    cq.offer(node.left);

                if (node.right != null)
                    cq.offer(node.right);
            }
            q = cq;
            result.add(levelResult);
        }

        return result;
    }
}
