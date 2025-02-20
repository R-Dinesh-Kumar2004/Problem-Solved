class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> hs = new HashSet<>();
        for(String s : nums) hs.add(s);

        String ans[] = new String[]{""};

        rec("",nums.length,hs,ans);

        return ans[0];
    }
    public void rec(String cur,int n,Set<String> hs , String ans[]){
        if(cur.length() == n){
            if(!hs.contains(cur)){
                ans[0] = cur;
            }
            return;
        }
        rec(cur+"1",n,hs,ans);
        if(!ans[0].isEmpty()) return;

        rec(cur+"0",n,hs,ans);
        if(!ans[0].isEmpty()) return;
    }
}