class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            int val = i*i;
            String s = ""+val;
            if(backtrack(0,i,0,s.length(),s)){
                ans += val;  
                // System.out.println(i+" "+val+" ");   
            }
        }
        return ans;
    }
    public boolean backtrack(int idx,int val,int pre,int n,String s){
        if(idx == n){
            return val == pre;
        }
        int sum = 0;
        for(int i=idx;i<n;i++){
            sum = Integer.parseInt(s.substring(idx,i+1));
            if(backtrack(i+1,val,pre+sum,n,s)) return true;
        }
        return false;
    }
}