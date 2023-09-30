import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int current;
    int parent;

    public Pair(int current, int parent) {
        this.current = current;
        this.parent = parent;
    }
}

public class DetectCycleUsingBFS {
    public static void main(String[] args) {
        int vertices = 7; // The number of vertices is 7
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int x = 0; x <= vertices; x++) { // Initialize from 0
            list.add(new ArrayList<>());
        }

        list.get(1).add(2);
        list.get(1).add(3);

        list.get(2).add(1);
        list.get(2).add(5);

        list.get(3).add(1);
        list.get(3).add(4);
        list.get(3).add(6);

        list.get(4).add(3);

        list.get(5).add(2);
        list.get(5).add(7);

        list.get(6).add(3);
        list.get(6).add(7);

        list.get(7).add(5);
        list.get(7).add(6);
        System.out.println(list);
        System.out.println("Is cycle present in the graph: " + isCycle(vertices, list));
    }

    public static boolean checkForCycle(int source, int vertices, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        visited[source] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, -1));
        while (!queue.isEmpty()) {
            int node = queue.peek().current;
            int parent = queue.peek().parent;
            queue.remove();
            for (int neighbour : list.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(new Pair(neighbour, node));
                } else if (parent != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> list) {
        boolean[] visited = new boolean[vertices + 1]; // Adjust the size here
        for (int x = 1; x <= vertices; x++) { // Start from 1
            if (!visited[x]) {
                if (checkForCycle(x, vertices, list, visited)) return true;
            }
        }
        return false;
    }
}
