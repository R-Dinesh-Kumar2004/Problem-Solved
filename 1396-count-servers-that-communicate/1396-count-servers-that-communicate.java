class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    vis[i][j] = true;
                    grid[i][j] = 0;
                    ans+=findConnection(i,j,m,n,grid,vis);
                }
            }
        }

        return ans;
    }
    public int findConnection(int a,int b,int m,int n,int grid[][],boolean vis[][]){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        int count = 0;
        while(!q.isEmpty()){
            int t[] = q.poll();
            int r = t[0], c = t[1];
            for(int i=0;i<m;i++){
                if(isValid(i,c,grid,vis)){
                        vis[i][c] = true;
                        grid[i][c] = 0;
                        q.add(new int[]{i,c});
                }
            }
            for(int i=0;i<n;i++){
                if(isValid(r,i,grid,vis)){
                    vis[r][i] = true;
                    grid[r][i] = 0;
                    q.add(new int[]{r,i});
                }
            }
            count++;
        }
        // System.out.print(count+" ");
        return count>1?count:0;
    }
    public boolean isValid(int i,int j,int grid[][],boolean vis[][]){
        return (grid[i][j]==1 && !vis[i][j]);
    }
}