class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++) adj.get(i).add(i+1);
        
        int len = queries.length;
        int ans[] = new int[len];
        for(int i=0;i<len;i++){
            int s = queries[i][0];
            int d = queries[i][1];

            adj.get(s).add(d);

            int pathLen = findPath(n,adj);
            ans[i] = pathLen;
        }
        return ans;
    }
    public int findPath(int n,List<List<Integer>> adj){
        boolean vis[] = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        vis[0] = true;

        while(!q.isEmpty()){
            int top[] = q.poll();
            int nd = top[0];
            int wt = top[1];

            if(nd == n-1) return wt;

            for(int it : adj.get(nd)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(new int[]{it,wt+1});
                }
            }
        }
        return -1;
    }
}