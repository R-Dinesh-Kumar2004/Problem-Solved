class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        boolean vis[][] = new boolean[m][n];
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        int ans[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;k++){
                int t[] = q.poll();
                for(int l=0;l<4;l++){
                    int i = t[0]+dx[l], j = t[1]+dy[l];
                    if(isValid(i,j,m,n,vis)){
                        q.add(new int[]{i,j});
                        vis[i][j] = true;
                    }
                }
                ans[t[0]][t[1]] = cnt;
            }
            cnt++;
        }
        return ans;
    }   
    public boolean isValid(int i,int j,int m,int n,boolean vis[][]){
        return (i>=0 && j>=0 && i<m && j<n && !vis[i][j]);
    }
}