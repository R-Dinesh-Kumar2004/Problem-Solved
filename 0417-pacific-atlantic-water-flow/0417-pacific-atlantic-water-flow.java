class Solution {
    int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        boolean pacific[][] = pacificOcean(heights,n,m);
        boolean atlantic[][] = atlanticOcean(heights,n,m);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(new ArrayList(Arrays.asList(i,j)));
                }
                // System.out.print(atlantic[i][j]+" ");
            }
            // System.out.println();
        }
        return ans;
    }
    public boolean[][] pacificOcean(int heights[][],int n,int m){
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            q.add(new int[]{i,0});
            vis[i][0] = true;
        }
        for(int i=1;i<m;i++){
            q.add(new int[]{0,i});
            vis[0][i] = true;
        }

        while(!q.isEmpty()){
            int top[] = q.poll();
            int i = top[0], j = top[1];

            for(int k=0;k<4;k++){
                int x = i + dir[k][0];
                int y = j + dir[k][1];

                if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y] && heights[i][j] <= heights[x][y]){
                    vis[x][y] = true;
                    q.add(new int[]{x,y});
                }
            }
        }

        return vis;
    }
    public boolean[][] atlanticOcean(int heights[][],int n,int m){
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            q.add(new int[]{i,m-1});
            vis[i][m-1] = true;
        }
        for(int i=0;i<m-1;i++){
            q.add(new int[]{n-1,i});
            vis[n-1][i] = true;
        }

        while(!q.isEmpty()){
            int top[] = q.poll();
            int i = top[0], j = top[1];

            for(int k=0;k<4;k++){
                int x = i + dir[k][0];
                int y = j + dir[k][1];

                if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y] && heights[i][j] <= heights[x][y]){
                    vis[x][y] = true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return vis;
    }
}