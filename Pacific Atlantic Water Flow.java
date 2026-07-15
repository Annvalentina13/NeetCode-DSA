class Solution {

    int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific (top row)
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
        }

        // Pacific (left column)
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
        }

        // Atlantic (bottom row)
        for (int c = 0; c < cols; c++) {
            dfs(heights, atlantic, rows - 1, c);
        }

        // Atlantic (right column)
        for (int r = 0; r < rows; r++) {
            dfs(heights, atlantic, r, cols - 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {

        if (visited[row][col])
            return;

        visited[row][col] = true;

        int rows = heights.length;
        int cols = heights[0].length;

        for (int[] dir : directions) {

            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                continue;

            if (visited[nr][nc])
                continue;

            if (heights[nr][nc] < heights[row][col])
                continue;

            dfs(heights, visited, nr, nc);
        }
    }
}
