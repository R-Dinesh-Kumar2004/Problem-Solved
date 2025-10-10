class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        Integer dp[] = new Integer[n];

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val = helper(i,energy,k,n,dp);
            ans = Math.max(ans,val);
        }

        return ans;
    }
    public int helper(int idx,int energy[],int k,int n,Integer dp[]){
        if(idx >= n) return 0;
        if(dp[idx] != null) return dp[idx];

        int pick = energy[idx] + helper(idx+k,energy,k,n,dp);

        return dp[idx] = pick;
    }
}