class Solution {
    int mod = (int)1e9+7;
    public int numberOfWays(int startPos, int endPos, int k) {
        if(startPos>endPos) return numberOfWays(endPos,startPos,k);
        int offset = Math.abs(startPos-k);
        int dp[][] = new int[offset+endPos+k+1][k+1];
        for(int it[] : dp) Arrays.fill(it,-1);

        return rec(startPos,endPos,k,dp,offset);
    }
    public int rec(int curr, int end,int k, int dp[][],int offset){
        if(k<0) return 0;
        if(curr == end && k == 0) return 1;

        if(dp[curr+offset][k] != -1) return dp[curr+offset][k];

        int left = rec(curr-1,end,k-1,dp,offset);
        int right = rec(curr+1,end,k-1,dp,offset);

        return dp[curr+offset][k] = (left+right)%mod;
    }
}
