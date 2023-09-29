import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int x = 1; x <= 9 ; x++){
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(1).add(3);
        list.get(2).add(1);
        list.get(2).add(5);
        list.get(2).add(6);
        list.get(3).add(1);
        list.get(3).add(4);
        list.get(3).add(7);
        list.get(4).add(3);
        list.get(4).add(8);
        list.get(5).add(2);
        list.get(6).add(2);
        list.get(7).add(3);
        list.get(7).add(8);
        list.get(8).add(4);
        list.get(8).add(7);

        System.out.println(list);
        System.out.println("Depth First Search: "+dfs(9,list));
    }
    // The function which returns DFS list
    public static ArrayList<Integer> dfs(int vertices, ArrayList<ArrayList<Integer>> list){
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> result = new ArrayList<>();
        recursiveDfs(1,visited,list,result);
        return result;
    }
    // The function which find dfs of a particular node using recursion
    public static void recursiveDfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        // Traverse all its neighbours
        for(int neighbours : list.get(node)){
            if(!visited[neighbours]){
                recursiveDfs(neighbours,visited,list,result);
            }
        }
    }
}
