import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Create a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0; // Count of fresh oranges
        int minutes = 0; // Minutes passed

        // Initialize the queue and count fresh oranges
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numCols; y++) {
                if (grid[x][y] == 2) {
                    queue.offer(new int[]{x, y});
                } else if (grid[x][y] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) {
            return 0;
        }

        // Define possible directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    // Check if the new position is within bounds and has a fresh orange
                    if (x >= 0 && x < numRows && y >= 0 && y < numCols && grid[x][y] == 1) {
                        grid[x][y] = 2; // Mark the orange as rotten
                        freshOranges--; // Decrease the count of fresh oranges
                        queue.offer(new int[]{x, y}); // Add the new rotten orange to the queue
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        // If there are still fresh oranges, return -1 (not all oranges can be rotten)
        return freshOranges == 0 ? minutes : -1;
    }
}
