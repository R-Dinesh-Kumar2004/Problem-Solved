class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[n];
        int dp1[] = new int[n];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        int takeF=robFirst(nums,n-2,dp);
        int takeL=robLast(nums,n-1,dp1);
        return Math.max(takeF,takeL);
    }
    public static int robFirst(int nums[],int i,int dp[]){
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i]+robFirst(nums,i-2,dp);
        int not = robFirst(nums,i-1,dp);
        return dp[i]=Math.max(take,not);
    }
    public static int robLast(int nums[],int i,int dp[]){
        if(i==1) return nums[1];
        if(i<1) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i]+robLast(nums,i-2,dp);
        int not = robLast(nums,i-1,dp);
        return dp[i]=Math.max(take,not);
    }
}