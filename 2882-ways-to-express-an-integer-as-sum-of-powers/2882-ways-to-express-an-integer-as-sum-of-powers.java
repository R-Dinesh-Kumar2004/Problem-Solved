class Solution {
    int mod = (int)(1e9+7);

    public int numberOfWays(int n, int x) {
        int len = 0;
        if(x == 1) len = n;
        else if(x == 2) len = pow2(n);
        else if(x == 3) len = pow3(n);
        else if(x == 4) len = pow4(n);
        else len = pow5(n);

        int nums[] = new int[len];
        for(int i=1;i<=len;i++){
            nums[i-1] = (int)Math.pow(i,x);
        }

        // System.out.println(len);

        Integer dp[][] = new Integer[len][n+1];
        return helper(0,nums,n,dp);
    }
    public int helper(int idx,int nums[],int target,Integer dp[][]){
        if(target == 0) return 1;
        if(idx == nums.length) return 0;
        if(dp[idx][target] != null) return dp[idx][target];

        int pick = 0;
        if(target >= nums[idx]){
            pick = helper(idx+1,nums,target-nums[idx],dp);
        }
        int not = helper(idx+1,nums,target,dp);

        return dp[idx][target] = (pick+not)%mod;
    }
    public int pow2(int n){
        int ans = 0;
        for(int i=1;i*i<=n;i++){
            ans = i;
        }
        return ans;
    }
    public int pow3(int n){
        int ans = 0;
        for(int i=1;i*i*i<=n;i++){
            ans = i;
        }
        return ans;
    }
    public int pow4(int n){
        int ans = 0;
        for(int i=1;i*i*i*i<=n;i++){
            ans = i;
        }
        return ans;
    }
    public int pow5(int n){
        int ans = 0;
        for(int i=1;i*i*i*i*i<=n;i++){
            ans = i;
        }
        return ans;
    }
}