class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long dp[][][] = new Long[n][k+1][3];
        return helper(0,0,prices,n,k,dp);
    }
    public long helper(int idx,int hold,int prices[],int n,int k,Long dp[][][]){
        if(idx == n){
            return (hold == 0) ? 0 : -1000000000;
        }
        if(k == 0){
            return (hold == 0) ? 0 : -1000000000;
        }

        if(dp[idx][k][hold] != null) return dp[idx][k][hold];

        long ans = 0;
        if(hold == 0){
            long buy = helper(idx+1,1,prices,n,k,dp)-prices[idx];
            long sBuy = helper(idx+1,2,prices,n,k,dp)+prices[idx];
            long skip = helper(idx+1,hold,prices,n,k,dp);

            ans = Math.max(buy,Math.max(sBuy,skip));
        }
        else if(hold == 1){
            long sell = helper(idx+1,0,prices,n,k-1,dp)+prices[idx];
            long not = helper(idx+1,hold,prices,n,k,dp);

            ans = Math.max(sell,not);
        }
        else{
            long sell = helper(idx+1,0,prices,n,k-1,dp)-prices[idx];
            long not = helper(idx+1,hold,prices,n,k,dp);

            ans = Math.max(sell,not);
        }

        return dp[idx][k][hold] = ans;
    }
}