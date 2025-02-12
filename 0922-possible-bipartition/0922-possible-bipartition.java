class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int it[]:dislikes){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        } 
        int vis[] = new int[n+1];
        Arrays.fill(vis,-1);

        for(int i=1;i<=n;i++){
            if(vis[i] == -1){
                if(!dfs(i,0,adj,vis)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int nd,int c,List<List<Integer>> adj, int vis[]){
        vis[nd] = c;
        for(int it : adj.get(nd)){
            if(vis[it] == -1){
                if(!dfs(it,1-c,adj,vis)) return false;
            }
            else if(vis[it] == c){
                return false;
            }
        }
        return true;
    }
}