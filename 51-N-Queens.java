class Solution {
    public List<List<String>> solveNQueens(int n) {
        char ch[][]=new char[n][n];
        for(char i[]:ch)Arrays.fill(i,'.');
        List<List<String>> li=new ArrayList<>();
        int left[]=new int[n];
        int upperD[]=new int[2*n-1];
        int lowerD[]=new int[2*n-1];
        solve(0,ch,left,upperD,lowerD,n,li);
        return li;
    }
    public void solve(int c,char ch[][],int left[],int upperD[],int lowerD[],int n,List<List<String>> li){
        if(c==n){
            List<String> l=new ArrayList<>();
            for(char i[]:ch){
                l.add(String.valueOf(i));
            }
            li.add(l);
            return;
        }
        for(int r=0;r<n;r++){
            if(left[r]==0 && upperD[n-1+c-r]==0 && lowerD[r+c]==0){
                ch[r][c]='Q';
                left[r]=1;
                upperD[n-1+c-r]=1;
                lowerD[c+r]=1;
                solve(c+1,ch,left,upperD,lowerD,n,li);
                ch[r][c]='.';
                left[r]=0;
                upperD[n-1+c-r]=0;
                lowerD[c+r]=0;
            }
        }
    }
}