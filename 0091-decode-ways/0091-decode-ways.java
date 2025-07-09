class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n];
        return helper(0,s,n,dp);
    }
    public int helper(int idx,String s,int n,Integer dp[]){
        if(idx == n) return 1;
        if(dp[idx] != null) return dp[idx];

        int count = 0;
        for(int i=idx;i<n;i++){
            if(i>idx+2) break;
            String t = s.substring(idx,i+1);
            int val = Integer.parseInt(t);
            if(val<27 && t.length() == (int)(Math.log10(val)+1)){
                count += helper(i+1,s,n,dp);
            }
        }
        return dp[idx] = count;
    }
}