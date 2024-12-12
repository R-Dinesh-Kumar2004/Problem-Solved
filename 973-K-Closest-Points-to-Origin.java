class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));

        for(int i[]:points){
            pq.offer(i);
        }
        int i=0;
        int ans[][]=new int[k][2];
        while(k-- > 0){
           ans[i++]=pq.poll();
        }
        return ans;
    }
}