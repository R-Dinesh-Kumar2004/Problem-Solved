class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum%2 == 1) return false;
        
        int n = nums.length;
        Boolean dp[][] = new Boolean[n][sum/2+1];

        return rec(0,nums,sum/2,n,dp);
    }
    public boolean rec(int idx,int nums[], int sum,int n,Boolean dp[][]){
        if(sum == 0) return true;
        if(sum < 0 || idx == n) return false;
        if(dp[idx][sum] != null) return dp[idx][sum];

        boolean pick = rec(idx+1,nums,sum-nums[idx],n,dp);
        if(pick) return true;
        boolean not =  rec(idx+1,nums,sum,n,dp);

        return dp[idx][sum] = (pick || not);
    }
}