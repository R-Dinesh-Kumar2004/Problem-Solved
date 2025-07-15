class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;

        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        Integer dp[][] = new Integer[n+2][n+2];

        return helper(1,n,arr,dp);
    }
    public int helper(int i,int j,int nums[],Integer dp[][]){
        if(i>j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int max = 0;
        for(int k=i;k<=j;k++){
            int points = (nums[i-1]*nums[k]*nums[j+1]) + helper(i,k-1,nums,dp) + helper(k+1,j,nums,dp);
            max = Math.max(max,points);
        }
        return dp[i][j] = max;
    }
}