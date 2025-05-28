class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[] = new int[10002];
        int max = 0;
        for(int i : nums){
            freq[i] += i;
            max = Math.max(max,i);
        } 
        Integer dp[] = new Integer[max+1];
        return helper(1,max,freq,dp);
    }
    public int helper(int idx,int max,int freq[],Integer dp[]){
        if(idx > max) return 0;
        if(dp[idx] != null) return dp[idx];

        int pick = freq[idx] + helper(idx+2,max,freq,dp);
        int not = helper(idx+1,max,freq,dp);

        return dp[idx] = Math.max(pick,not);
    }
}