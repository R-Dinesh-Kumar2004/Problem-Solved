class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int r, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(Math.abs(a[0]-r)+Math.abs(a[1]-c))-(Math.abs(b[0]-r)+Math.abs(b[1]-c)));
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                pq.offer(new int[]{i,j});
            }
        }

        int ans[][] = new int[rows*cols][2];
        int i=0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll();
            // int arr[]=pq.poll();
            // System.out.println(Arrays.toString(arr));
            i++;
        }
        return ans;
    }
}