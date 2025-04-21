class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0;
        long sum = 0;

        for(int i : differences){
            sum += i;
            if(sum>max) max = sum;
            else if(sum<min) min = sum;
        }
        long ans = (upper-lower)-(max-min)+1;
        if(ans<0) return 0;
        return (int)ans;
    }
}