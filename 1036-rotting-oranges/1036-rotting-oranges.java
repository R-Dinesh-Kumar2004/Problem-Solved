class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fruits = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) fruits++;
            }
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        boolean vis[][] = new boolean[m][n];
        int minutes = -1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;k++){
                int t[] = q.poll();
                for(int l=0;l<4;l++){
                    int i = t[0]+dx[l];
                    int j = t[1]+dy[l];
                    if(isValid(i,j,m,n,grid,vis)){
                        q.add(new int[]{i,j});
                        vis[i][j] = true;
                        fruits--;
                    }
                }
            }
            minutes++;
        }
        if(fruits>0) return -1;
        return minutes==-1?0:minutes;
    }
    public boolean isValid(int i,int j,int m,int n,int grid[][],boolean vis[][]){
        return (i>=0 && i<m && j>=0 && j<n && grid[i][j]==1 && !vis[i][j]);
    }
}