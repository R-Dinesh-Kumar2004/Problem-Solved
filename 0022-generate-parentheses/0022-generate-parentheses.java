class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("",0,0,ans,n);
        return ans;
    }
    public void helper(String s,int open,int close,List<String> ans,int n){
        if((open+close) == 2*n){
            ans.add(s);
            return;
        }

        if(open > close){
            helper(s+")",open,close+1,ans,n);
        }
        if(open < n) helper(s+"(",open+1,close,ans,n);
    }
}