class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int flag = 0, ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && flag == 0){
                    change(i,j,n,grid);
                    flag = 1;
                }
                else if(grid[i][j] == 1){
                    ans = Math.min(ans,bfs(i,j,n,grid));
                }
            }
        }
        return ans;
    }
    public void change(int i,int j,int n,int grid[][]){
        grid[i][j] = 2;
        for(int k=0;k<4;k++){
            int x = i+dx[k];
            int y = j+dy[k];
            if(isValid(x,y,n) && grid[x][y] == 1){
                change(x,y,n,grid);
            }
        }
    }
    public int bfs(int i,int j,int n,int grid[][]){
        boolean vis[][] = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{i,j,0});

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int x = top[0];
            int y = top[1];
            int wt = top[2];
            
            if(grid[x][y] == 2) return wt-1;

            if(vis[x][y]) continue;
            vis[x][y] = true;

            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(isValid(nx,ny,n) && grid[nx][ny] != 1){
                    if(!vis[nx][ny]){
                        pq.offer(new int[]{nx,ny,wt+1});
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public boolean isValid(int x,int y,int n){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}