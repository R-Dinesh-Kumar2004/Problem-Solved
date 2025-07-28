class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean dp[] = new Boolean[n];
        return helper(0,s,wordDict,dp);
    }
    public boolean helper(int idx,String str,List<String> word,Boolean dp[]){
        if(idx == str.length()){
            return true;
        }
        if(dp[idx] != null) return dp[idx];

        for(String s : word){
            if(isMatch(idx,str,s)){
                if(helper(idx+s.length(),str,word,dp)) return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
    public boolean isMatch(int idx,String str,String s){
        int n = s.length();
        if(idx+n > str.length()) return false;

        for(int i=0;i<n;i++,idx++){
           if(str.charAt(idx) != s.charAt(i)) return false;
        }

        return true;
    }
}