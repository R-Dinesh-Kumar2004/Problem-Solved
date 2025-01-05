class Solution {
    public int maxDistToClosest(int[] seats) {
        int max=0,count=0,pre=-1;
        for(int i:seats){
            if(i==0) count++;
            else{
                if(pre==-1) pre=count;
                max=Math.max(max,count);
                count=0;
            }
        }
        return Math.max(Math.max(pre,count),(max+1)/2);
    }
}