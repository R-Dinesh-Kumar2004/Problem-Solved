class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean vis[] = new boolean[n];
        for(int it : restricted) vis[it] = true;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[] : edges){
            int s = it[0],d = it[1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int nd = q.poll();
            vis[nd] = true;
            count++;
            for(int it : adj.get(nd)){
                if(!vis[it]){
                    q.add(it);
                }
            }
            // System.out.print(nd+" ");
        }
        return count;
    }
}