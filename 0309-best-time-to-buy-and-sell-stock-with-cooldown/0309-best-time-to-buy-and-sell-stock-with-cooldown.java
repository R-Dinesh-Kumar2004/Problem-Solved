class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n][2];
        return helper(0,0,prices,n,dp);
    }
    public int helper(int idx,int hold,int prices[],int n,Integer dp[][]){
        if(idx>=n) return 0;
        if(dp[idx][hold] != null) return dp[idx][hold];

        int ans = 0;
        if(hold == 0){
            int buy = helper(idx+1,1,prices,n,dp)-prices[idx];
            int skip = helper(idx+1,hold,prices,n,dp);
            ans = Math.max(buy,skip);
        }
        else{
            int sell = helper(idx+2,0,prices,n,dp)+prices[idx];
            int not = helper(idx+1,hold,prices,n,dp);
            ans = Math.max(sell,not);
        }
        return dp[idx][hold] = ans;
    }
}