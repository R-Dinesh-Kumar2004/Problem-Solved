class Solution {
    int mod = (int)(1e9+7);
    public int checkRecord(int n) {
        Long dp[][][] = new Long[n+1][2][3];
        return (int)helper(n,0,0,dp);
    }
    public long helper(int n,int absCount,int lateCount,Long dp[][][]){
        if(n == 0) return 1;
        if(dp[n][absCount][lateCount] != null) return dp[n][absCount][lateCount];

        long ans = 0;
        ans = helper(n-1,absCount,0,dp);
        if(absCount < 1) ans = (ans + helper(n-1,absCount+1,0,dp))%mod;
        if(lateCount < 2) ans = (ans + helper(n-1,absCount,lateCount+1,dp))%mod;

        return dp[n][absCount][lateCount] = ans;
    }
}