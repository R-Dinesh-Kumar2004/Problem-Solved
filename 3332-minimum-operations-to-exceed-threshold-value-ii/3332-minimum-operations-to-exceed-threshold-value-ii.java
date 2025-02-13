class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num :nums) pq.offer(num);

        int operation = 0;
        while(pq.size()>1){
            if(pq.peek()>=k) return operation;

            long f = pq.poll(), s = pq.poll();
            long val = 2*Math.min(f,s) + Math.max(f,s);

            pq.offer(val);
            operation++;
        }
        return operation;
    }
}