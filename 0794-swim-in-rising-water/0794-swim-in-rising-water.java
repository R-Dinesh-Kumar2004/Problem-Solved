class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        boolean vis[][] = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        vis[0][0] = true;

        int ans = -1;
        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int i = top[0];
            int j = top[1];
            int wt = top[2];
            ans = Math.max(ans,wt);
            if(i==n-1 && j==n-1){
                return ans;
            }

            for(int k=0;k<4;k++){
                int x = i+dx[k];
                int y = j+dy[k];

                if(isValid(x,y,n,vis)){
                    vis[x][y] = true;
                    pq.add(new int[]{x,y,grid[x][y]});
                }
            }
        }
        return -1;
    }
    public static boolean isValid(int i,int j,int n,boolean vis[][]){
        return (i>=0 && j>=0 && i<n && j<n && !vis[i][j]);
    }
}