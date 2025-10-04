class Solution {
    int dx[] = {0,0,-1,1};
    int dy[] = {-1,1,0,0};

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<m;i++){
            pq.add(new int[]{heightMap[0][i],0,i});
            pq.add(new int[]{heightMap[n-1][i],n-1,i});
            vis[0][i] = vis[n-1][i] = true;
        }
        for(int i=1;i<n-1;i++){
            pq.add(new int[]{heightMap[i][0],i,0});
            pq.add(new int[]{heightMap[i][m-1],i,m-1});
            vis[i][0] = vis[i][m-1] = true;
        }

        int level = 0;
        int ans = 0;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int hei = top[0], x = top[1], y = top[2];
            level = Math.max(level,top[0]);

            if(hei < level) ans += level-hei;

            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(isValid(newX,newY,n,m) && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    pq.add(new int[]{heightMap[newX][newY],newX,newY});
                }
            }
        }

        return ans;
    }
    public boolean isValid(int x,int y,int n,int m){
        return (x >=0 && y >= 0 && x < n && y < m);
    }
}