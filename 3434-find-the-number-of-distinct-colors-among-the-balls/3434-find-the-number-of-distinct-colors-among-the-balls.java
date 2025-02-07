class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        Map<Integer,Integer> balls = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        int idx = 0;
        for(int q[] : queries){
            int b = q[0];
            int c = q[1];

            if(balls.getOrDefault(b,0)==0){
                balls.put(b,c);
                color.put(c,color.getOrDefault(c,0)+1);
            }
            else{
                int oldColor = balls.get(b);
                if(color.get(oldColor)==1) color.remove(oldColor);
                else color.put(oldColor,color.get(oldColor)-1);

                balls.put(b,c);
                color.put(c,color.getOrDefault(c,0)+1);
            }
            ans[idx++] = color.size();
        }
        return ans;
    }
}