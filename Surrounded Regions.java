class Solution {

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // First and last column
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        // First and last row
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Convert cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return;

        if (board[row][col] != 'O')
            return;

        // Mark as safe
        board[row][col] = 'T';

        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1]);
        }
    }
}
