class Solution {
    int mod = (int)(1e9+7);
    public int[] baseUnitConversions(int[][] con) {
        int n = con.length+1;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int it[] : con){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }

        int ans[] = new int[n];
        dfs(0,1L,adj,ans);

        return ans;
    }
    public void dfs(int nd,long pro,List<List<int[]>> adj,int ans[]){
        ans[nd] = (int)pro;
        for(int it[] : adj.get(nd)){
            dfs(it[0],(pro*it[1])%mod,adj,ans);
        }
    }
}