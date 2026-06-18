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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Queue<TreeNode> cq = new LinkedList<>();
            boolean notAdded = true;
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (notAdded) {
                    result.add(node.val);
                    notAdded = false;
                }

                if (node.right != null)
                    cq.offer(node.right);

                if (node.left != null)
                    cq.offer(node.left);

            }
            q = cq;
        }

        return result;        
    }
}
