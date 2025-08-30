class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isValid(i,j,board))return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int r,int c,char board[][]){
        Set<Character> row=new HashSet<>();
        Set<Character> col=new HashSet<>();
        Set<Character> mat=new HashSet<>();

        for(int i=0;i<9;i++){
            
            if(board[i][c]!='.' && !row.add(board[i][c]))return false;
            if(board[r][i]!='.' && !col.add(board[r][i]))return false;
            char ch=board[3*(r/3)+i/3][3*(c/3)+i%3];
            if(ch!='.' && !mat.add(ch))return false;
        }
        return true;
    }
}