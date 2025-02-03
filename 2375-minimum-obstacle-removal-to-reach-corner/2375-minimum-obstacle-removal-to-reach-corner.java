class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int i = top[0];
            int j = top[1];
            int removal = top[2];

            if(i==m-1 && j==n-1) return removal;
            for(int k=0;k<4;k++){
                int x = i+dx[k];
                int y = j+dy[k];

                if(isValid(x,y,m,n,vis)){
                    vis[x][y] = true;
                    pq.add(new int[]{x,y,removal+grid[x][y]});
                }
            }
        }
        return -1;
    }
    public boolean isValid(int i,int j,int m,int n,boolean vis[][]){
        return (i>=0 && i<m && j>=0 && j<n && !vis[i][j]);
    }
}