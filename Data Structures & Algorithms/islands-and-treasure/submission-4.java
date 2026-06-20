public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. Add all treasure locations to the queue
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. Multi-source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                
                // If neighbor is within bounds and is an empty space (INF)
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}