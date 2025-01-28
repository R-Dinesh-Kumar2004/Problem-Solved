class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int battles = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'X'){
                    battles++;
                    dfs(i,j,m,n,board);
                }
            }
        }
        return battles;
    }
    public void dfs(int i,int j,int m,int n,char board[][]){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='.') return;
        board[i][j] = '.';
        dfs(i+1,j,m,n,board);
        dfs(i-1,j,m,n,board);
        dfs(i,j+1,m,n,board);
        dfs(i,j-1,m,n,board);
    }
}