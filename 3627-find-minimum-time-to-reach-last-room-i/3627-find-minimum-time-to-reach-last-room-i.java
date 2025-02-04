class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int i = top[0];
            int j = top[1];
            int sec = top[2];

            if(i==n-1 && j==m-1) return sec;

            for(int k=0;k<4;k++){
                int x = i+dx[k];
                int y = j+dy[k];

                if(isValid(x,y,n,m,vis)){
                    vis[x][y] = true;
                    if(sec>=moveTime[x][y]){
                        pq.add(new int[]{x,y,sec+1});
                    }
                    else{
                        int wait = moveTime[x][y]-sec;
                        pq.add(new int[]{x,y,sec+wait+1});
                    }
                } 
            }
        }
        return -1;
    }
    public boolean isValid(int i,int j,int n,int m,boolean vis[][]){
        return (i>=0 && i<n && j>=0 && j<m && !vis[i][j]);
    }
}