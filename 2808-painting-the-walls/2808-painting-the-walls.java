class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer dp[][] = new Integer[n][n+1];

        return helper(0,n,cost,time,dp);
    }
    public int helper(int idx,int remain,int cost[],int time[],Integer dp[][]){
        if(remain<=0) return 0;
        if(idx == cost.length) return (int)(1e9);

        if(dp[idx][remain] != null) return dp[idx][remain];

        int pick = cost[idx] + helper(idx+1,remain-1-time[idx],cost,time,dp);
        int not = helper(idx+1,remain,cost,time,dp);

        return dp[idx][remain] = Math.min(pick,not); 
    }
}