import java.util.ArrayList;

public class AdjencyLists {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int x = 1; x <= 5 ; x++){
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(2).add(1);

        list.get(3).add(2);
        list.get(2).add(3);

        list.get(1).add(3);
        list.get(3).add(1);

        System.out.println(list);
    }
}
