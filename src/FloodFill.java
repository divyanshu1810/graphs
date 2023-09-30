public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        if (startColor != newColor) {
            dfs(image, sr, sc, newColor, startColor);
        }
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int startColor) {
        int numRows = image.length;
        int numCols = image[0].length;

        if (i < 0 || i >= numRows || j < 0 || j >= numCols || image[i][j] != startColor) {
            return;
        }

        // Mark the current cell with the new color.
        image[i][j] = newColor;

        // Recursively explore neighboring cells.
        dfs(image, i - 1, j, newColor, startColor); // Up
        dfs(image, i + 1, j, newColor, startColor); // Down
        dfs(image, i, j - 1, newColor, startColor); // Left
        dfs(image, i, j + 1, newColor, startColor); // Right
    }
}
