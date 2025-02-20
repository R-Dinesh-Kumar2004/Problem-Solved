class Solution {
    public int longestCycle(int[] edges) {
        int v = edges.length;
        int indeg[] = new int[v];
        for(int it:edges){
           if(it != -1) indeg[it]++;
        } 

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indeg[i] == 0) q.add(i);
        }
        boolean vis[] = new boolean[v];

        while(!q.isEmpty()){
            int node = q.poll();
            if(edges[node] == -1) continue;

            vis[node] = true;

            indeg[edges[node]]--;
            if(indeg[edges[node]] ==  0) q.add(edges[node]);
        }
        // for(int i=0;i<v;i++) System.out.print(indeg[i]+" ");
        int max = 0;
        for(int i=0;i<v;i++){
            if(!vis[i] && indeg[i] != 0){
                max = Math.max(max,dfs(i,edges,vis));
            }
        }
        
        return max == 0 ? -1 : max;
    }
    public int dfs(int nd,int edges[],boolean vis[]){
        if(vis[nd]) return 0;
        vis[nd] = true;

        int cycle = 1;

        cycle += dfs(edges[nd],edges,vis);

        return cycle;
    }
}