class Solution {
    public int maximumScore(int a, int b, int c) {
        int score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        pq.add(a); 
        pq.add(b);
        pq.add(c);

        while(pq.size()>1){
            int f = pq.poll();
            int s = pq.poll();

            score++;

            if(f-1 != 0) pq.add(f-1);
            if(s-1 != 0) pq.add(s-1);
        }
        return score;
    }
}