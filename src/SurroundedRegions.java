import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] arr = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(arr);
        for(char[] ar: arr){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[x].length;y++){
                if((x==0 || y==0 || y==board[x].length-1 || x==board.length-1) && !visited[x][y] && board[x][y]=='O'){
                    System.out.println(board[x][y]);
                    dfs(board,visited,x,y);
                }
            }
        }
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[x].length;y++){
                if(!visited[x][y] && board[x][y]=='O'){
                    board[x][y]='X';
                }
            }
        }
    }
    private static void dfs(char[][] grid,boolean[][] visited, int i, int j) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] == 'X' || visited[i][j]) {
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
