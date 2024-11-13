class Solution {
    public int findMaxFish(int[][] grid) {
        int max=0;
        int r=grid.length;
        int c=grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]!=0){
                    int area=dfs(i,j,r,c,grid);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int i,int j,int r,int c,int grid[][]){
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j]==0){
            return 0;
        }

        int area=grid[i][j];
        grid[i][j]=0;
        area+=dfs(i,j-1,r,c,grid);
        area+=dfs(i-1,j,r,c,grid);
        area+=dfs(i,j+1,r,c,grid);
        area+=dfs(i+1,j,r,c,grid);

        return area;
    }
}