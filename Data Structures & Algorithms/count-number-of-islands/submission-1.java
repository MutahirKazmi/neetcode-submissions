class Solution {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!this.visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;        
    }

    public void dfs(char[][] grid, int i, int j) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{i, j});

        while (!stack.isEmpty()) {
            Integer[] popped = stack.pop();
            i = popped[0];
            j = popped[1];

            this.visited[i][j] = true;

            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir: dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newI < grid.length 
                && newJ >= 0 && newJ < grid[0].length 
                && grid[newI][newJ] == '1' 
                && !visited[newI][newJ]) {
                    stack.push(new Integer[]{newI, newJ});
                }
            }
        }
    }    
}
