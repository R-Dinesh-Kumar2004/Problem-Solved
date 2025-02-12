class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> hm = new HashMap<>();

        for(int num : nums){
            int SOD = findSOD(num);
            if(!hm.containsKey(SOD)){
                hm.put(SOD,new PriorityQueue<>((a,b)->b-a));
            }
            hm.get(SOD).add(num);
        }

        int max = -1;
        for(Map.Entry<Integer,PriorityQueue<Integer>> en : hm.entrySet()){
            PriorityQueue<Integer> pq = en.getValue();
            if(pq.size() == 1) continue;
            int f = pq.poll();
            int s = pq.poll();

            max = Math.max(max,f+s);
        }
        return max;
    }
    public int findSOD(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}