class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Integer dp[][] = new Integer[n][n+1];
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        return helper(0,-1,pairs,n,dp);
    }
    public int helper(int idx,int prevIdx,int pairs[][],int n,Integer dp[][]){
        if(idx == n) return 0;
        if(dp[idx][prevIdx+1] != null) return dp[idx][prevIdx+1];
        int pick = 0;
        if(prevIdx == -1 || pairs[prevIdx][1]<pairs[idx][0]){
            pick = 1 + helper(idx+1,idx,pairs,n,dp);
        }
        int not = helper(idx+1,prevIdx,pairs,n,dp);
        return dp[idx][prevIdx+1] = Math.max(pick,not);
    }
}