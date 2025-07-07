class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = events.length;
        int idx = 0,time = 1,ans = 0;

        while(idx<n || !pq.isEmpty()){
            if(pq.isEmpty()){
                time = Math.max(time,events[idx][0]);
            }

            while(idx<n && events[idx][0] == time){
                pq.add(events[idx][1]);
                idx++;
            }

            while(!pq.isEmpty() && pq.peek()<time){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
            time++;
        }
        return ans;
    }
}