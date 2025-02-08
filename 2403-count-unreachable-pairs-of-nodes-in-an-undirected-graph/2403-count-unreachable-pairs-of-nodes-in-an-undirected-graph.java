class Solution {
    public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            return ((long)n*(n-1))/2;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[] : edges){
            int s = it[0];
            int d = it[1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        List<Integer> li = new ArrayList<>();

        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int cnt = dfs(i,adj,vis);
                li.add(cnt);
            }
        }
        int len = li.size();
        if(len == 1) return 0;
        long ans = 0;

        for(int i=0;i<len;i++){
            long val = li.get(i);
            for(int j=i+1;j<len;j++){
                ans+=val*li.get(j);
            }
        } 
        return ans;
    }
    public int dfs(int nd,List<List<Integer>> adj,boolean vis[]){
        vis[nd] = true;
        int cnt = 1;
        for(int it : adj.get(nd)){
            if(!vis[it]){
                cnt+=dfs(it,adj,vis);
            }
        }
        return cnt;
    }
}