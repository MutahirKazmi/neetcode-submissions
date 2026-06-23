class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyMatrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int totalCourses = 0;

        while (!q.isEmpty()) {
            Queue<Integer> cQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Integer polled = q.poll();
                totalCourses++;
                for (Integer edge : adjacencyMatrix.get(polled)) {
                    indegree[edge]--;
                    if (indegree[edge] == 0) {
                        cQ.offer(edge);
                    }
                }
            }
            q = cQ;
        }

        return totalCourses == numCourses;
    }
}
