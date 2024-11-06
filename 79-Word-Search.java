class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length,c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0)){
                    if(check(i,j,r,c,board,0,word))return true;
                }
            }
        }
        return false;
    }
    public boolean check(int i,int j,int r,int c,char arr[][],int idx,String word){
        if(idx==word.length())return true;
        if(i<0 || i>=r || j<0 || j>=c || arr[i][j]!=word.charAt(idx)){
            return false;
        }
        char t=arr[i][j];
        arr[i][j]='0';
        boolean found=check(i-1,j,r,c,arr,idx+1,word)||
                      check(i+1,j,r,c,arr,idx+1,word)||
                      check(i,j-1,r,c,arr,idx+1,word)||
                      check(i,j+1,r,c,arr,idx+1,word);
        arr[i][j]=t;
        return found;
    }
}