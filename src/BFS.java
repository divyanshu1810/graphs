import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    // Complexity: O(N)
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int x = 1; x <= 10 ; x++){
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(1).add(6);

        list.get(2).add(1);
        list.get(2).add(3);
        list.get(2).add(4);

        list.get(3).add(2);

        list.get(4).add(2);
        list.get(4).add(5);

        list.get(5).add(4);
        list.get(5).add(8);

        list.get(6).add(1);
        list.get(6).add(7);
        list.get(6).add(9);

        list.get(7).add(6);
        list.get(7).add(8);

        list.get(8).add(5);
        list.get(8).add(7);

        list.get(9).add(6);

        System.out.println(list);
        System.out.println("Breadth First Search: "+bfs(10,list));
    }
    public static ArrayList<Integer> bfs(int vertices, ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> result = new ArrayList<>();
        // A visited boolean array to track whether this node was visited or not!
        boolean[] visited = new boolean[vertices];
        // A queue to implement FIFO algorithm
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(int neighbours : list.get(node)){
                if(!visited[neighbours]){
                    visited[neighbours]=true;
                    queue.add(neighbours);
                }
            }
        }
        return result;
    }
}
