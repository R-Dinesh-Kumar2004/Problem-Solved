class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int it : nums) pq.offer(it);
        
        while(k-->0){
            int val = pq.poll();
            pq.add(val+1);
        }
        int mod = (int)1e9+7;
        long ans = 1;

        while(!pq.isEmpty()){
            int val = pq.poll();
            ans = (ans*val)%mod;
        }

        return (int)ans;
    }
}