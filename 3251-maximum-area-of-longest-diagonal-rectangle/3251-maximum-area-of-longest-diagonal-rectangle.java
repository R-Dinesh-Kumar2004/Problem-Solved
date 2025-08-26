class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDio = 0;
        int area = 0;

        for(int it[] : dimensions){
            int l = it[0], w = it[1];

            double d = Math.sqrt(l*l+w*w);

            if(maxDio < d){
                area = l*w;
                maxDio = d;
            }
            else if(maxDio == d){
                area = Math.max(area,l*w);
            }
        }
        return area;
    }
}