class Solution {
    int sum = 0;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        
        return dp[0][0];
    }
    public int rec(int i,int j,int n,List<List<Integer>> tri,int dp[][]){
        if(i==n-1){
            return tri.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];

        int down = rec(i+1,j,n,tri,dp);
        int dright = rec(i+1,j+1,n,tri,dp);

        dp[i][j] = tri.get(i).get(j)+Math.min(down,dright);

        return dp[i][j];
    }
}