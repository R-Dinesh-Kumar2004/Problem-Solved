class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int f = 0,l = n-1;
        while(row[l] == 0) l--;
        while(row[f] == 0) f++;

        int height = (l-f)+1;

        f = 0; l = m-1;
        while(col[l] == 0) l--;
        while(col[f] == 0) f++;

        int width = (l-f)+1;

        return width*height;
    }
}