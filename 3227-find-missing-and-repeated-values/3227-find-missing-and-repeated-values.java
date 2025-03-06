class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int freq[] = new int[n*n+1];

        for(int it[] : grid){
            for(int val : it) freq[val]++;
        }
        int mis = -1,rep = -1;
        for(int i=1;i<=n*n;i++){
            if(freq[i] == 0) mis = i;
            if(freq[i] == 2) rep = i;
        }
        return new int[]{rep,mis};
    }
}