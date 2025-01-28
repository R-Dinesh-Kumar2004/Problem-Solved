class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            // System.out.println(cur[0]+" "+cur[1]);
            for(int k=0;k<4;k++){
                int i = cur[0]+dx[k];
                int j = cur[1]+dy[k];
                if(isValid(i,j,m,n,grid)){
                    grid[i][j] = 1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int closedIsland = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    dfs(i,j,m,n,grid);
                    closedIsland++;
                }
                // System.out.print(grid[i][j]+" ");
            }
            // System.out.println();
        }
        return closedIsland;
    }
    public void dfs(int i,int j,int m,int n,int grid[][]){
        if(!isValid(i,j,m,n,grid)) return;
        grid[i][j] = 1;
        dfs(i+1,j,m,n,grid);
        dfs(i-1,j,m,n,grid);
        dfs(i,j+1,m,n,grid);
        dfs(i,j-1,m,n,grid);
    }
    public boolean isValid(int i,int j,int m,int n,int grid[][]){
        return (i>=0 && i<m && j>=0 && j<n && grid[i][j]==0); 
    }
}