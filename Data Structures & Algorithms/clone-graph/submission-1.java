/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> oldToNewNode = new HashMap<>();


    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        oldToNewNode.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {
            Node popped = q.poll();

            for (Node neighbor: popped.neighbors) {
                if (!oldToNewNode.containsKey(neighbor)) {
                    oldToNewNode.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }                

                oldToNewNode.get(popped).neighbors.add(oldToNewNode.get(neighbor));
            }
        }

        return oldToNewNode.get(node);        
    }
}