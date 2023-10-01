public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(numEnclaves(arr));
    }
    public static int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[x].length;y++){
                if((x==0 || y==0 || y==grid[x].length-1 || x==grid.length-1) && !visited[x][y] && grid[x][y]==1){
                    dfs(grid,visited,x,y);
                }
            }
        }
        int count=0;
        for (int x=0;x<grid.length;x++){
            for (int y=0;y< grid[x].length;y++){
                if(grid[x][y]==1 && !visited[x][y]){
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] grid,boolean[][] visited, int i, int j) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        // Mark the current cell as visited.
        visited[i][j]=true;

        // Recursively explore neighboring cells.
        dfs(grid,visited, i - 1, j); // Up
        dfs(grid,visited, i + 1, j); // Down
        dfs(grid,visited, i, j - 1); // Left
        dfs(grid,visited, i, j + 1); // Right
    }
}
