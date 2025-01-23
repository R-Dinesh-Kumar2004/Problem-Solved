class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){ 
            if(board[0][i]=='O'){ //left
                q.add(new int[]{0,i});
                vis[0][i] = true;
            }
            if(board[m-1][i]=='O'){
                q.add(new int[]{m-1,i});
                vis[m-1][i] = true;
            }
        }
        for(int i=1;i<m-1;i++){
            if(board[i][0]=='O'){
                q.add(new int[]{i,0});
                vis[i][0] = true;
            }
            if(board[i][n-1]=='O'){
                q.add(new int[]{i,n-1});
                vis[i][n-1] = true;
            }
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;k++){
                int t[] = q.poll();
                for(int l=0;l<4;l++){
                    int i = t[0]+dx[l], j = t[1]+dy[l];
                    if(isValid(i,j,m,n,vis,board)){
                        q.add(new int[]{i,j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    if(!vis[i][j]) board[i][j] = 'X';
                }
            }
        }
    }
    public boolean isValid(int i,int j,int m,int n,boolean vis[][], char arr[][]){
        return (i>=0 && i<m && j>=0 && j<n && !vis[i][j] && arr[i][j]=='O');
    }
}