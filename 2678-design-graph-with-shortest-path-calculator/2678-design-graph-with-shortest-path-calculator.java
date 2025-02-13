class Graph {
    List<List<int[]>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[] : edges){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        boolean vis[] = new boolean[n];    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{node1,0});

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int nd = top[0];
            int wt = top[1];

            if(nd == node2) return wt;

            if(vis[nd]) continue;
            vis[nd] = true;

            for(int it[] : adj.get(nd)){
                if(!vis[it[0]]){
                    pq.add(new int[]{it[0],wt+it[1]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */