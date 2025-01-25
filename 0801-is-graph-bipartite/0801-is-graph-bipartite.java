class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int vis[] = new int[v];
        Arrays.fill(vis,-1);
        for(int i=0;i<v;i++){
            if(vis[i] == -1){
                if(!bfs(i,graph,vis)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int nd,int graph[][],int vis[]){
        vis[nd] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(nd);
        while(!q.isEmpty()){
            int t = q.poll();
            for(int it:graph[t]){
                if(vis[it] == -1){
                    vis[it] = vis[t]==0?1:0;
                    q.offer(it);
                }
                else{
                    if(vis[it]==vis[t]) return false;
                }
            }
        }
        return true;
    }
}