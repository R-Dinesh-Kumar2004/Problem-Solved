class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int ways[] = new int[n];
        Arrays.fill(ways,1);

        int maxLen = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        ways[i] = ways[j];
                    }
                    else if(dp[j]+1 == dp[i]){
                        ways[i] += ways[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxLen){
                ans += ways[i];
            }
        }

        return ans;
    }
}