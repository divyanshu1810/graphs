public class Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; // Handle null or empty input
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int count = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited.
        grid[i][j] = '0';

        // Recursively explore neighboring cells.
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
    }
}
