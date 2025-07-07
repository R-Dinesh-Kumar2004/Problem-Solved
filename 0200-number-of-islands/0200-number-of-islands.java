class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;

        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,r,c,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,int r,int c,char arr[][]){
        if(i<0 || j<0 || i>=r || j>=c || arr[i][j]=='0')return;
        arr[i][j]='0';
        dfs(i,j-1,r,c,arr);
        dfs(i-1,j,r,c,arr);
        dfs(i,j+1,r,c,arr);
        dfs(i+1,j,r,c,arr);
    }
}