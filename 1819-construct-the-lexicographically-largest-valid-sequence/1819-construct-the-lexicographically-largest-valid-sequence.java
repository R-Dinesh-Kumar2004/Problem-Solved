class Solution {
    public int[] constructDistancedSequence(int n) {
        int ans[] = new int[2*n-1];
        boolean vis[] = new boolean[n+1];
        rec(0,n,ans,vis);
        return ans;
    }
    public boolean rec(int idx,int n,int ans[],boolean vis[]){
        if(idx == 2*n-1) return true;
        if(ans[idx] != 0) return rec(idx+1,n,ans,vis);

        for(int i=n;i>=1;i--){
            if(vis[i]) continue;

            vis[i] = true;
            ans[idx] = i;
            if(i == 1 && rec(idx+1,n,ans,vis)) return true;
            if(i>1 && idx+i < (2*n-1) && ans[idx+i] == 0){
                ans[idx+i] = i;
                if(rec(idx+1,n,ans,vis)) 
                    return true;
                ans[idx+i] = 0;
            }
            ans[idx] = 0;
            vis[i] = false;
        }
        return false;
    }
}