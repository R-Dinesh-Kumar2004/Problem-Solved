class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];

        Arrays.fill(dp[0],1);
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0)dp[i][0]=1;
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}