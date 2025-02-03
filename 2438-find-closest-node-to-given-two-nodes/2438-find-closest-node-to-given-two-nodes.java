class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dis1[] = findDistance(edges,node1);
        int dis2[] = findDistance(edges,node2);
        int ans = -1,min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           if(dis1[i] != Integer.MAX_VALUE && dis2[i] != Integer.MAX_VALUE){
              int sum = Math.max(dis1[i],dis2[i]);
              if(min>sum){
                min = sum;
                ans = i;
              }
           }
        // System.out.print(dis2[i]+" ");
        }
        return ans;
    }
    public int[] findDistance(int edges[],int nd){
        Queue<Integer> q = new LinkedList<>();
        int dis[] = new int[edges.length];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[nd] = 0;
        q.add(nd);
        while(!q.isEmpty()){
            int node = q.poll();
            int cur = edges[node];
            if(cur != -1){
                if(dis[node]+1<dis[cur]){
                    dis[cur] = dis[node]+1;
                    q.add(cur);
                }
            }
        }
        return dis;
    }
}