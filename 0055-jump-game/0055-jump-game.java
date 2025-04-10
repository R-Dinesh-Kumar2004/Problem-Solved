class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        return rec(0,nums,n,dp);
    }
    public boolean rec(int idx,int nums[],int n,Boolean dp[]){
        if(idx == n-1) return true;
        if(idx >= n) return false;
        if(dp[idx] != null) return dp[idx];

        boolean itReachEnd = false;
        int move = nums[idx];
        for(int i=1;i<=move;i++){
            itReachEnd |= rec(idx+i,nums,n,dp);
            if(itReachEnd) return dp[idx] = true;
        }
        return dp[idx] = itReachEnd;
    }
}