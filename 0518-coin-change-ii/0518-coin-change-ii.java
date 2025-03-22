class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return rec(n-1,coins,amount,dp);
    }
    public int rec(int idx,int coins[],int sum,int dp[][]){
        if(sum == 0) return 1;
        if(idx<0) return 0;
        if(dp[idx][sum] != -1) return dp[idx][sum];

        int pick = 0;
        if(sum>=coins[idx]) pick = rec(idx,coins,sum-coins[idx],dp);
        int not = rec(idx-1,coins,sum,dp);

        return dp[idx][sum] = pick+not;
    }
}