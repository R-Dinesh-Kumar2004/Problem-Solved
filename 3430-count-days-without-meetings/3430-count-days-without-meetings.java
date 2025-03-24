class Solution {
    public int countDays(int days, int[][] meetings) {
        int count = 0, last = 1;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        for(int meet[] : meetings){
           if(last<meet[0]){
            count += meet[0] - last;
           }
           last = Math.max(last,meet[1]+1);
        }
        if(days>=last) count += days-last+1;

        return count;
    }
}