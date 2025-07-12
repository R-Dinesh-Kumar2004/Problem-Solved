class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()];
        return helper(0,0,s,p,dp);
    }
    public boolean helper(int i,int j,String s,String p,Boolean dp[][]){
        int n = s.length();
        int m = p.length();
        if(i == n && j == m) return true;
        if(i == n){
            for(int k=j;k<m;k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(j == m) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = helper(i+1,j+1,s,p,dp);
        }
        else if(p.charAt(j) == '*'){
            return dp[i][j] = (helper(i,j+1,s,p,dp) || helper(i+1,j+1,s,p,dp) || helper(i+1,j,s,p,dp));
        }
        return false;
    }
}