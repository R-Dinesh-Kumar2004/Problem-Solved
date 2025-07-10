class Solution {
    int dx[] = {1,1,0,-1,-1,-1,0,1};
    int dy[] = {0,1,1,1,0,-1,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1) return -1;

        boolean vis[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int top[] = q.poll();
            int x = top[0],y = top[1],wt = top[2];

            if(x == n-1 && y == n-1) return wt;

            for(int i=0;i<8;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX>=0 && newY>=0 && newX<n && newY<n && grid[newX][newY] == 0 && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    q.add(new int[]{newX,newY,wt+1});
                }
            }
        }
        return -1;
    }
}