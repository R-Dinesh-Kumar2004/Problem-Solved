class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n][k+1][2];
        return helper(0,0,k,prices,n,dp);
    }
    public int helper(int idx,int hold,int k,int prices[],int n,Integer dp[][][]){
        if(idx == n || k == 0) return 0;
        if(dp[idx][k][hold] != null) return dp[idx][k][hold];
        
        int ans = 0;

        if(hold == 0){
            int buy = helper(idx+1,1,k,prices,n,dp)-prices[idx];
            int skip = helper(idx+1,hold,k,prices,n,dp);
            ans = Math.max(buy,skip);
        }
        else{
            int sell = helper(idx+1,0,k-1,prices,n,dp)+prices[idx];
            int not = helper(idx+1,hold,k,prices,n,dp);
            ans = Math.max(sell,not);
        }
        
        return dp[idx][k][hold] = ans;
    }
}