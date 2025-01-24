class Solution {
    boolean safe_state[];
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        safe_state = new boolean[v];
        Arrays.fill(safe_state,true);
        int vis[] = new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,graph,vis);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(safe_state[i]) ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int nd,int graph[][],int vis[]){
        vis[nd] = 1;
        boolean isSafe = true;
        for(int it:graph[nd]){
            if(vis[it]==0){
                isSafe &= dfs(it,graph,vis);
            }
            else if(vis[it]==1){
                return safe_state[nd] = false;
            }
            else{
                isSafe &= safe_state[it];
            }
        }
        vis[nd] = 2;
        return safe_state[nd] = isSafe;
    }
}