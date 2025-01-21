class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long up = 0;
        for(int i=0;i<n;i++){
            up+=grid[0][i];
        }
        long bot = 0,ans = 10000000000000L;
        for(int i=0;i<n;i++){
            up-=grid[0][i];
            ans = Math.min(ans,Math.max(up,bot));
            bot+=grid[1][i];
        }
        return ans;
    }
}