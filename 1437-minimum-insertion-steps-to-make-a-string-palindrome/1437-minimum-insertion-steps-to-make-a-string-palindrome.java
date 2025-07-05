class Solution {
    public int minInsertions(String s1) {
        String s2 = new StringBuffer(s1).reverse().toString();
        int n = s1.length();
        Integer dp[][] = new Integer[n][n];

        return n - helper(0,0,s1,s2,dp);
    }
    public int helper(int i,int j,String s1,String s2,Integer dp[][]){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int same = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            same = 1 + helper(i+1,j+1,s1,s2,dp);
        }
        int notSame = Math.max(helper(i+1,j,s1,s2,dp),helper(i,j+1,s1,s2,dp));

        return dp[i][j] = Math.max(same,notSame);
    }
}