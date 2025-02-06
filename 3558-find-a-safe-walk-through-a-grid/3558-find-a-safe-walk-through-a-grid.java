class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int mat[][] = new int[m][n];
        int r = 0;
        for(List<Integer> l:grid){
            int c = 0;
            for(int val:l){
                mat[r][c] = val;
                c++;
            }
            r++;
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        boolean vis[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,mat[0][0]});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int i = top[0];
            int j = top[1];
            int reduce = top[2];

            if(reduce>=health) continue;
            if(i==m-1 && j==n-1) return true;
            
            for(int k=0;k<4;k++){
                int x = i+dx[k];
                int y = j+dy[k];

                if(isValid(x,y,m,n,vis)){
                    vis[x][y] = true;
                    if(mat[x][y] == 1) pq.add(new int[]{x,y,reduce+1});
                    else pq.add(new int[]{x,y,reduce});
                }
            }
        }
        return false;
    }
    public boolean isValid(int x,int y,int m,int n,boolean vis[][]){
        return (x>=0 && y>=0 && x<m && y<n && !vis[x][y]);
    }
}