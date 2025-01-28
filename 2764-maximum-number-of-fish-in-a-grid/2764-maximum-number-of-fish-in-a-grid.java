class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    int val = dfs(i,j,m,n,grid);
                    ans = Math.max(ans,val);
                }
            }
        }
        return ans;
    }
    public int dfs(int i,int j,int m,int n,int grid[][]){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0) return 0;

        int sum = grid[i][j];
        grid[i][j] = 0;
        sum+=dfs(i+1,j,m,n,grid);
        sum+=dfs(i-1,j,m,n,grid);
        sum+=dfs(i,j+1,m,n,grid);
        sum+=dfs(i,j-1,m,n,grid);

        return sum;
    }
}