class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        Integer dp[][][] = new Integer[n][n+1][k+1];
        return helper(0,nums,k,-1,dp);
    }
    public int helper(int idx,int nums[],int k,int pIdx, Integer dp[][][]){
        if(idx == nums.length) return 0;  
        if(dp[idx][pIdx+1][k] != null) return dp[idx][pIdx+1][k];

        int flag = (pIdx == -1 || nums[idx] == nums[pIdx]) ? 0 : 1; 
        int pick = 0;
        if(flag <= k){
            pick = 1 + helper(idx+1,nums,k-flag,idx,dp);
        }
        int not = helper(idx+1,nums,k,pIdx,dp);

        return dp[idx][pIdx+1][k] = Math.max(pick,not);
    }
}