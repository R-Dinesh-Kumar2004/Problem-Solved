class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[]:flights){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }

        int priceArr[] = new int[n];
        Arrays.fill(priceArr,Integer.MAX_VALUE);
        priceArr[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{src,0,0}); // 0->src 1->stops 2->price

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int csrc = top[0];
            int step = top[1];
            int price = top[2];
            if(csrc == dst) return price;

            for(int it[]:adj.get(csrc)){
                if(step<=k && price+it[1]<priceArr[it[0]]){
                    priceArr[it[0]] = price+it[1];
                    pq.add(new int[]{it[0],step+1,price+it[1]});
                }
            }
        }
        return -1;
    }
}