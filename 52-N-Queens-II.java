class Solution {
    public int totalNQueens(int n) {
        int left[]=new int[n];
        int upperD[]=new int[2*n-1];
        int lowerD[]=new int[2*n-1];
        int count[]=new int[1];
        solve(0,left,upperD,lowerD,n,count);
        return count[0];
    }
    public void solve(int c,int left[],int upperD[],int lowerD[],int n,int count[]){
        if(c==n){
            count[0]++;
            return;
        }
        for(int r=0;r<n;r++){
            if(left[r]==0 && upperD[n-1+c-r]==0 && lowerD[r+c]==0){
                left[r]=1;
                upperD[n-1+c-r]=1;
                lowerD[c+r]=1;
                solve(c+1,left,upperD,lowerD,n,count);
                left[r]=0;
                upperD[n-1+c-r]=0;
                lowerD[c+r]=0;
            }
        }
    }
}