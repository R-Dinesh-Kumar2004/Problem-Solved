class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
            
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});

        while(!q.isEmpty()){
            int node[] = q.poll();
            for(int it[]:adj.get(node[0])){
                if(node[1]+it[1]<dis[it[0]]){
                    dis[it[0]] = node[1]+it[1];
                    q.add(new int[]{it[0],node[1]+it[1]});
                }
            }
        }

        int ans = 0;
        for(int i=1;i<=n;i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dis[i]);
        }
        return ans;
    }
}