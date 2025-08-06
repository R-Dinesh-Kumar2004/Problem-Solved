class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Long> hm = new HashMap<>();
        
        for(int rec[] : rectangles){
            double ratio = (double)rec[0]/rec[1];
            hm.put(ratio,hm.getOrDefault(ratio,0L)+1);
        }

        long ans = 0;
        for(long val : hm.values()){
            ans += (val*(val-1)/2);
        }

        return ans;
    }
}