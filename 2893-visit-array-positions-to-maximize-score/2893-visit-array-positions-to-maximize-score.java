class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long dp[][] = new long[n][2];
        long ans = rec(nums[0]%2,1,nums,n,x,dp);
        return ans+nums[0];
    }
    public long rec(int prev,int cur,int nums[],int n,int x,long dp[][]){
        if(cur == n) return 0;
        if(dp[cur][prev] != 0) return dp[cur][prev];

        long penalty = (prev != nums[cur]%2) ? x : 0;
        long pick = nums[cur] - penalty + rec(nums[cur]%2,cur+1,nums,n,x,dp);
        long not = rec(prev,cur+1,nums,n,x,dp);

        return dp[cur][prev] = Math.max(pick,not);
    }
}