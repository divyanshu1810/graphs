import java.util.ArrayList;

public class DetectCycleUsingDFS {
    public static void main(String[] args) {
        int vertices = 8; // The number of vertices is 7
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
    public static boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> list){
        boolean[] visited = new boolean[vertices];
        for(int x=0 ;x<vertices;x++){
            if(!visited[x]){
                if(dfs(x,-1,visited,list)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> list){
        visited[node] = true;
        for (int neighbour : list.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,node,visited,list)){
                    return true;
                }
            } else if (neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
}
