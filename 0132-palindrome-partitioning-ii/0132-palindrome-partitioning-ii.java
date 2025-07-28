class Solution {
    public int minCut(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n];
        return helper(0,s,n,dp)-1;
    }

    public int helper(int idx,String s,int n,Integer dp[]){
        if(idx == n) return 0;
        if(dp[idx] != null) return dp[idx];

        int min = n;
        for(int i=idx;i<n;i++){
            if(isPalindrome(idx,i,s)){
                int cost = 1 + helper(i+1,s,n,dp);
                min = Math.min(min,cost);
            }
        }
        return dp[idx] = min;
    }
    
    public boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}