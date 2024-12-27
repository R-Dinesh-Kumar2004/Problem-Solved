class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int pos=values[0];
        int max=0;
        for(int j=1;j<n;j++){
            int val=values[j]-j;
            max=Math.max(max,pos+val);
            pos=Math.max(pos,values[j]+j);
        }
        return max;
    }
}