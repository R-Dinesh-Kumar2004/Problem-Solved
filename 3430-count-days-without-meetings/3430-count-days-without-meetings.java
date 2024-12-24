class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int tot=0;
        int prev=1;
        for(int i[]:meetings){
            if(i[0]>prev){
                tot+=i[0]-prev;
            }
            prev=Math.max(prev,i[1]+1);
        }
        if(days>=prev)tot+=days-prev+1;
        return tot;
    }
}