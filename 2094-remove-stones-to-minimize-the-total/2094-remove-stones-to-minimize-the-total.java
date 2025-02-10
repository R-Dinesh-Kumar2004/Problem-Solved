class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int it : piles) pq.offer(it);

        for(int i=0;i<k;i++){
            int val = pq.poll();
            pq.offer((int)Math.ceil(val/2.0));
        }
    
        int remain = 0;
        while(!pq.isEmpty()){
            int val = pq.poll();
            remain += val;
            System.out.print(val+" ");
        }
        return remain;
    }
}