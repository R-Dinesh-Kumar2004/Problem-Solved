class Solution {
    int mod = (int)(1e9+7);
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Long dp[][][] = new Long[m][n][16];
        return (int)helper(0,0,0,grid,k,dp);
    }
    public long helper(int i,int j,int xor,int grid[][],int k,Long dp[][][]){
        int m = grid.length,n = grid[0].length;
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1){
            return ((xor^grid[i][j]) == k) ? 1 : 0;
        }
        if(dp[i][j][xor] != null) return dp[i][j][xor];
        
        long right = helper(i,j+1,xor^grid[i][j],grid,k,dp);
        long down = helper(i+1,j,xor^grid[i][j],grid,k,dp);

        return dp[i][j][xor] = (right+down)%mod;
    }
}