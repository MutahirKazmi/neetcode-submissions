class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // BFS setup
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // Start BFS: [current_node, parent_node]
        queue.add(new int[]{0, -1});
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adj.get(node)) {
                // If neighbor is the parent, skip it
                if (neighbor == parent) continue;
                
                // If already visited, we found a cycle
                if (visited.contains(neighbor)) return false;
                
                visited.add(neighbor);
                queue.add(new int[]{neighbor, node});
            }
        }

        // If connected, visited size must equal n
        return visited.size() == n;
    }
}