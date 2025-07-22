class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()];
        return helper(0,0,s,p,dp);
    }
    public boolean helper(int i,int j,String s,String p,Boolean dp[][]){
        if(i == s.length() && j >= p.length()) return true;
        if(i == s.length()){
            for(int k=j;k<p.length();k+=2){
                if(k+1 >= p.length() || p.charAt(k+1) != '*') return false;
            }
            return true;
        }
        if(j >= p.length()) return false;

        if(dp[i][j] != null) return dp[i][j];

        boolean nextStr = (j+1<p.length() && p.charAt(j+1) == '*');

        if(nextStr){
            if(helper(i,j+2,s,p,dp)) return dp[i][j] = true;

            if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && helper(i+1,j,s,p,dp)) return dp[i][j] = true;

            return dp[i][j] = false;
        }
        else{
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return dp[i][j] = helper(i+1,j+1,s,p,dp);
            else return dp[i][j] = false;
        }

    }
}