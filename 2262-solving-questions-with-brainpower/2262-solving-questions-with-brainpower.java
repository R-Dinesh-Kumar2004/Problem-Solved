class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return rec(0,questions,n,dp);
    }
    public long rec(int idx,int questions[][],int n,long dp[]){
        if(idx>=n) return 0;
        if(dp[idx] != -1) return dp[idx];

        long pick = questions[idx][0] + rec(idx+questions[idx][1]+1,questions,n,dp);
        long not = rec(idx+1,questions,n,dp);

        return dp[idx] = Math.max(pick,not);
    }
}