class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;
        int dp[][] = new int[n][m];

        for(int i=0;i<n;i++){
            dp[i][0] = matrix[i][0];
            if(dp[i][0] == 1) count++;
        }
        for(int i=1;i<m;i++){
            dp[0][i] = matrix[0][i];
            if(dp[0][i] == 1) count++;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0) continue;

                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;

                count += dp[i][j];
            }
        }

        return count;
    }
}