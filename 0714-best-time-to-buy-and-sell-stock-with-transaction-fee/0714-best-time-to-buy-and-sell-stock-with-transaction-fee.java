class Solution {
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        int n = prices.length;
        Integer dp[][] = new Integer[n][2];
        return helper(0,0,prices,dp);
    }
    public int helper(int idx,int hold,int prices[],Integer dp[][]){
        if(idx == prices.length) return 0;
        if(dp[idx][hold] != null) return dp[idx][hold];

        int ans = 0;
        if(hold == 0){
            int buy = helper(idx+1,1,prices,dp)-prices[idx];
            int skip = helper(idx+1,hold,prices,dp);
            ans = Math.max(buy,skip);
        }
        else{
            int sell = helper(idx+1,0,prices,dp)+prices[idx]-fee;
            int skip = helper(idx+1,hold,prices,dp);
            ans = Math.max(sell,skip);
        }
        return dp[idx][hold] = ans;
    }
}