class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1){
                        q.add(new int[]{i,j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int t[] = q.poll();
            for(int l=0;l<4;l++){
               int i = t[0]+dx[l];
               int j = t[1]+dy[l];
               if(isValid(i,j,m,n,grid,vis)){
                   q.add(new int[]{i,j});
                   vis[i][j] = true;
               }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !vis[i][j]) count++;
            }
        }
        return count;
    }
    public static boolean isValid(int i,int j,int m,int n,int grid[][],boolean vis[][]){
        return (i>=0 && j>=0 && i<m && j<n && grid[i][j]==1 && !vis[i][j]);
    }
}