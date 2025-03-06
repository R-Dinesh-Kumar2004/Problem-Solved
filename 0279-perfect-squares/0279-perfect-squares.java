class Solution {
    public int numSquares(int n) {
        int squares[] = new int[101];
        for(int i=1;i<=100;i++){
           squares[i] = i*i;
        }
        int dp[][] = new int[101][n+1];
        for(int it[]:dp) Arrays.fill(it,-1);
        int ans = rec(1,n,squares,dp);
        return ans;
    }
    public int rec(int idx,int sum,int squares[],int dp[][]){
        if(sum == 0) return 0;
        if(idx == 101) return Integer.MAX_VALUE;

        if(dp[idx][sum] != -1) return dp[idx][sum];

        int take = 0;
        if(squares[idx]<=sum){
            take = rec(idx,sum-squares[idx],squares,dp);
            if(take != Integer.MAX_VALUE) take++;
        }
        else return Integer.MAX_VALUE;
        int not = rec(idx+1,sum,squares,dp);

        return dp[idx][sum] = Math.min(take,not);
    }
}