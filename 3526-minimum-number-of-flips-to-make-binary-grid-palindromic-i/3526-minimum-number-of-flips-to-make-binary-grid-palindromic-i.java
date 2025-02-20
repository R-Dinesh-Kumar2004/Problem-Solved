class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        int row = 0;
        for(int i=0;i<m;i++){
            int l = 0,r = n-1;
            while(l<r){
                if(grid[i][l] != grid[i][r]) row++;
                l++; r--;
            }
        }
        int col = 0;
        for(int i=0;i<n;i++){
            int l = 0,r = m-1;
            while(l<r){
                if(grid[l][i] != grid[r][i]) col++;
                l++; r--;
            }
        }

        return row > col ? col : row;
    }
}