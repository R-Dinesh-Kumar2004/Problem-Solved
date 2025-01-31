class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];

        dfs(0,rooms,vis);

        for(boolean b : vis){
            if(!b) return false;
        }
        return true;
    }
    public void dfs(int nd,List<List<Integer>> adj, boolean vis[]){
        vis[nd] = true;
        for(int it:adj.get(nd)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
}