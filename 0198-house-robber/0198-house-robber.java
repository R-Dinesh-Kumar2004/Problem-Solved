class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return rec(nums,n-1,dp);
    }
    public static int rec(int nums[],int i,int dp[]){
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+rec(nums,i-2,dp);
        int not = rec(nums,i-1,dp);
        dp[i]=Math.max(pick,not);
        return dp[i];
    }
}