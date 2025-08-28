class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int row = 0,col = 0;
        
        for(int i=1;i<n;i++){
            row = 0;
            col = i;
            List<Integer> list = new ArrayList<>();
            while(row < n && col < n){
                list.add(grid[row][col]);
                row++; col++;
            }
            Collections.sort(list);
            row = 0;
            col = i;
            int idx = 0;
            while(row < n && col < n){
                grid[row][col] = list.get(idx++);
                row++; col++;
            }
        }

        for(int i=0;i<n;i++){
            row = i;
            col = 0;
            List<Integer> list = new ArrayList<>();
            while(row < n && col < n){
                list.add(grid[row][col]);
                row++; col++;
            }
            Collections.sort(list);
            row = i;
            col = 0;
            int idx = list.size();
            while(row < n && col < n){
                grid[row][col] = list.get(--idx);
                row++; col++;
            }
        }
        return grid;
    }
}