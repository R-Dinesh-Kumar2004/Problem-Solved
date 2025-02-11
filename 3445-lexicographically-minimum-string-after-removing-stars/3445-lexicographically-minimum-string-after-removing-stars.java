class Solution {
    class Pair{
        char c;
        int idx;
        Pair(char c,int idx){
            this.c = c;
            this.idx = idx;
        }
    }
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.c == b.c){
                return b.idx-a.idx;
            }
            return a.c-b.c;
        });
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i=0;i<n;i++){
           char c = s.charAt(i);
           if(c == '*'){
            count++;
             int idx = pq.peek().idx;
             pq.poll();
             sb.setCharAt(idx,'#');
           }
           else{
             sb.append(c);
             pq.offer(new Pair(c,i-count));
           }
        }
        // System.out.print(sb.toString());
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<sb.length();i++){
           char c = sb.charAt(i);
           if(c != '#') ans.append(c);
        }
        return ans.toString();
    }
}