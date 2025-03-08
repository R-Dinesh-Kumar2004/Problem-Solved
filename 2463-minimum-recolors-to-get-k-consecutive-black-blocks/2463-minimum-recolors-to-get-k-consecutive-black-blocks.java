class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int bColor = 0;
        for(int i=0;i<k;i++){
           if(blocks.charAt(i) == 'B')bColor++;
        }

        int max = bColor;
        for(int i=k;i<n;i++){
            if(blocks.charAt(i) == 'B') bColor++;
            if(blocks.charAt(i-k) == 'B') bColor--;

            max = Math.max(max,bColor);
        }
        return k-max;
    }
}