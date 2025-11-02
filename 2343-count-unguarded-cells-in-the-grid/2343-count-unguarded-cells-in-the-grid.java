class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int arr[][]=new int[m][n];
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<guards.length;i++){
            arr[guards[i][0]][guards[i][1]]=-1;
        }

        for(int i=0;i<walls.length;i++){
            arr[walls[i][0]][walls[i][1]]=-1;
        }

        for(int guard[]:guards){
            int x=guard[0],y=guard[1];
            for(int dir[]:dirs){
                int r=x+dir[0],c=y+dir[1];

                while(r>=0 && r<m && c>=0 && c<n){
                    if(arr[r][c]==-1)break;
                    else if(arr[r][c]==0)arr[r][c]=1;
                    r+=dir[0];
                    c+=dir[1];
                }
            }
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0)count++;
            }
        }
        return count;
    }
}