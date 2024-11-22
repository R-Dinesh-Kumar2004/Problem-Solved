class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;

        int r=grid.length;
        int c=grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,r,c,grid));
                }
            }
        }
        return max;
    }

    public int dfs(int i,int j,int r,int c,int grid[][]){
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int area=1;
        area+=dfs(i-1,j,r,c,grid)
        +dfs(i,j-1,r,c,grid)
        +dfs(i+1,j,r,c,grid)
        +dfs(i,j+1,r,c,grid);

        return area;
    }
}