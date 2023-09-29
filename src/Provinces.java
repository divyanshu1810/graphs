import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Provinces {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjacencyList = adjacencyMatrixToList(isConnected);
        int count = 0;
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                count++;
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : adjacencyList.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return count;
    }

    public ArrayList<ArrayList<Integer>> adjacencyMatrixToList(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    neighbors.add(j);
                }
            }
            adjacencyList.add(neighbors);
        }

        return adjacencyList;
    }
}
