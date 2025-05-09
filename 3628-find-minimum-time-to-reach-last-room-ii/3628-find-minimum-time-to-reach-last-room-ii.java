class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};
        boolean vis[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0,0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int x = top[0],y = top[1],wt = top[2];
            
            if(x == m-1 && y == n-1) return wt;

            for(int k=0;k<4;k++){
                int i = dx[k]+x;
                int j = dy[k]+y;

                if(i>=0 && j>=0 && i<m && j<n && !vis[i][j]){
                    vis[i][j] = true;
                    int t = (wt<moveTime[i][j]) ? moveTime[i][j] : wt;
                    if(top[3] == 1) t += 1;
                    pq.add(new int[]{i,j,t+1,1-top[3]});
                }
            }
        }
        return -1;
    }
}