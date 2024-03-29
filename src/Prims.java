class Pair{
    int node;
    int distance;
    public Pair(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}

class Prims{
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0,0));
        int sum = 0;
        while(pq.size()>0){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if(vis[node]==1) continue;
            vis[node]=1;
            sum+=wt;

            for(int i = 0;i<adj.get(node).size();i++){
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(vis[adjNode]==0){
                    pq.add(new Pair(edW, adjNode));
                }
            }
        } 
        return sum;
    }
}