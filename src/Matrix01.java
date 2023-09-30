import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] results = updateMatrix(matrix);
        for (int[] row : results) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n]; // To store distance values
        Queue<int[]> q = new LinkedList<>(); // Queue for BFS

        // Initialize the queue with cells containing 0 and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Initialize non-zero cells with a large value
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // Possible directions to explore

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            // Explore neighbors in all four directions
            for (int[] d : dir) {
                int nrow = row + d[0];
                int ncol = col + d[1];

                // Check if the neighbor is within bounds and if updating the distance is beneficial
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        dist[nrow][ncol] > dist[row][col] + 1) {
                    // Update distance and enqueue unvisited neighbors
                    dist[nrow][ncol] = dist[row][col] + 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        return dist; // Return the matrix with updated distances
    }
}
