class Solution {
    class Pair{
        int i,j;
        int val;
        Pair(int val,int i,int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;      
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(0,i,j));
                    vis[i][j] = true;
                }
            }
        }
        int ans[][] = new int[m][n];
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        int count=0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;k++){
                Pair p = q.poll(); 
                for(int l=0;l<4;l++){
                    int i=p.i+dx[l],j=p.j+dy[l];
                    if(isValid(i,j,m,n,vis)){
                        q.add(new Pair(mat[i][j],i,j));
                        vis[i][j] = true;
                    }
                }
                ans[p.i][p.j] = count;
            }
            count++;
        }
        return ans;
    }
    public boolean isValid(int i,int j,int m,int n,boolean vis[][]){
        return (i>=0 && j>=0 && i<m && j<n && !vis[i][j]);
    }
}