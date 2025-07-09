class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    public int maximumMinutes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fireTime[][] = calculateFireTime(grid,n,m);
        int low = 0,high = 1000_000_000;
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(isValid(grid,fireTime,mid)){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }

        return ans;
    }
    public int[][] calculateFireTime(int grid[][],int n,int m){
        int fireTime[][] = new int[n][m];
        for(int it[] : fireTime) Arrays.fill(it,Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    fireTime[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int top[] = q.poll();
            int x = top[0],y = top[1];

            for(int k=0;k<4;k++){
                int newX = x+dx[k];
                int newY = y+dy[k];

                if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY] == 0 && fireTime[newX][newY] == Integer.MAX_VALUE){
                    fireTime[newX][newY] = fireTime[x][y]+1;
                    q.add(new int[]{newX,newY});
                }
            }
        }
        return fireTime;
    }
    public boolean isValid(int grid[][],int fireTime[][],int st){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,st});
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;

        while(!q.isEmpty()){
            int top[] = q.poll();
            int x = top[0],y = top[1],time = top[2];

            if(x == n-1 && y == m-1) return true; 

            for(int k=0;k<4;k++){
                int newX = x+dx[k];
                int newY = y+dy[k];

                if(newX<0 || newX>=n || newY<0 || newY>=m || grid[newX][newY] != 0 || vis[newX][newY]) continue;
                vis[newX][newY] = true;

                if(time+1<fireTime[newX][newY]){
                    q.add(new int[]{newX,newY,time+1});
                }
                else if(time+1 == fireTime[newX][newY] && newX == n-1 && newY == m-1){
                    q.add(new int[]{newX,newY,time+1});
                }
            }
        }
        return false;
    }
}