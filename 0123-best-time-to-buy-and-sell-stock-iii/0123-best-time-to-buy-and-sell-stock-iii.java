class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n][2][3];
        return helper(0,0,prices,n,2,dp);
    }
    public int helper(int idx,int hold,int prices[],int n,int k,Integer dp[][][]){
        if(idx == n || k == 0) return 0;
        if(dp[idx][hold][k] != null) return dp[idx][hold][k];
        
        int ans = 0;

        if(hold == 0){
            int buy = helper(idx+1,1,prices,n,k,dp)-prices[idx];
            int skip = helper(idx+1,hold,prices,n,k,dp);

            ans = Math.max(buy,skip);
        }
        else{
            int sell = helper(idx+1,0,prices,n,k-1,dp)+prices[idx];
            int not = helper(idx+1,1,prices,n,k,dp);

            ans = Math.max(sell,not);
        }

        return dp[idx][hold][k] = ans;
    }
}