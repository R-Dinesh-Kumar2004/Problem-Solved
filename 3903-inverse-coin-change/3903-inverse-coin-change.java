class Solution {
    public List<Integer> findCoins(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            int ways = coinChange((i+1),ans);
            if(ways == nums[i]) continue;
            else if((ways+1) == nums[i]) ans.add((i+1)); 
            else return new ArrayList<>();
        }
        return ans;
    }
    public int coinChange(int target,List<Integer> li){
        int n = li.size();
        int coins[] = new int[n];
        for(int i=0;i<n;i++) coins[i] = li.get(i);
        Integer dp[][] = new Integer[n][target+1];

        return helper(0,coins,target,dp);
    }
    public int helper(int idx,int coins[],int target,Integer dp[][]){
        if(target == 0) return 1;
        if(idx == coins.length) return 0;
        if(dp[idx][target] != null) return dp[idx][target];

        int pick = 0;
        if(target>=coins[idx]){
            pick = helper(idx,coins,target-coins[idx],dp);
        }
        int not = helper(idx+1,coins,target,dp);

        return dp[idx][target] = (pick+not);
    }
}