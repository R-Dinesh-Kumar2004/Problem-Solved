class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indeg[] = new int[n];
        for(int it[] : roads){
            indeg[it[0]]++; indeg[it[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++) pq.offer(indeg[i]);

        long val = 1;
        long sum = 0;

        while(!pq.isEmpty()){
            int ind = pq.poll();
            sum += val*ind;
            val++;
        }
        return sum;
    }
}