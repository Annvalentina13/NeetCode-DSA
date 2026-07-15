class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure cells to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;

                // Visit only unprocessed land
                if (grid[nr][nc] != Integer.MAX_VALUE)
                    continue;

                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
