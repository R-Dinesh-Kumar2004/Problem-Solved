class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<m;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
           for(int j=0;j<m;j++){
               if(isConnected[i][j]==1){
                 adj.get(i).add(j);
                 adj.get(j).add(i);
               }
           }
        }
        boolean vis[] = new boolean[m];
        int connected = 0;
        for(int i=0;i<m;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                connected++;
            }
        }
        return connected;
    }
    public void dfs(int nd,List<List<Integer>> adj,boolean vis[]){
        vis[nd] = true;
        for(int it:adj.get(nd)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
}