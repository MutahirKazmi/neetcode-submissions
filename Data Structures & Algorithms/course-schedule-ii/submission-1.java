class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            Queue<Integer> cQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Integer polled = q.poll();
                result.add(polled);
                for (Integer edge : adjacencyMatrix.get(polled)) {
                    indegree[edge]--;
                    if (indegree[edge] == 0) {
                        cQ.offer(edge);
                    }
                }
            }
            q = cQ;
        }

        if (result.size() == numCourses) {
            int[] array = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array[i] = result.get(i);
            }
            return array;
        } else {
            return new int[]{};
        }

    }
}
