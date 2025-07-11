class Solution {
    public int numDistinct(String s, String t) {
        Integer dp[][] = new Integer[s.length()][t.length()];
        return helper(0,0,s,t,dp);
    }
    public int helper(int i,int j,String s,String t,Integer dp[][]){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = (helper(i+1,j+1,s,t,dp)+helper(i+1,j,s,t,dp));
        }
        else return dp[i][j] = helper(i+1,j,s,t,dp);
    }
}