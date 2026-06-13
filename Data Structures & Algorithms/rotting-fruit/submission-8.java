class Solution {
    int[][] directions = new int[][]{
        new int[]{0,-1},
        new int[]{0,1},
        new int[]{-1,0},
        new int[]{1,0},
    };

        public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }


    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<Integer[]>();
        int freshFruits = 0;
        int rottenFruits = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenFruits++;
                    q.offer(new Integer[]{i, j});
                }

                if (grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }

    // If there are no fresh fruits, it takes 0 minutes
    if (freshFruits == 0) {
        return 0;
    }

    // Now check if there are no rotten fruits to spread
    if (q.isEmpty()) {
        return -1;
    }

        int minute = 0;

        while (!q.isEmpty()) {
            if (freshFruits == 0) {
                return minute;
            }
            
            Queue<Integer[]> childQueue = new LinkedList<Integer[]>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer[] coordinates = q.poll();
                for (int j = 0; j < directions.length; j++) {
                    int newRow = coordinates[0] + directions[j][0];
                    int newCol = coordinates[1] + directions[j][1];

                    if (newRow >= 0 && newRow < grid.length 
                    && newCol >= 0 && newCol < grid[0].length) {
                        if (grid[newRow][newCol] == 1) {
                            childQueue.offer(new Integer[]{newRow, newCol});
                            grid[newRow][newCol] = 2;
                            rottenFruits++;
                            freshFruits--;
                        }
                    }
                }
            }
            q = childQueue;
            minute++;
        }

        return -1;
        
    }
}
