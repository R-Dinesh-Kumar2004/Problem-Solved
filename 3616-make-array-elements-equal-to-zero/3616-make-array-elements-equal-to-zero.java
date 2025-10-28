class Solution {
    public int countValidSelections(int[] nums) {
        int tot=0;
        for(int i:nums)tot+=i;
        int count=0,sum=0;
        for(int i:nums){
            sum+=i;
            tot-=i;
            if(i==0){
                if(tot==sum)count+=2;
                else if(Math.abs(tot-sum)==1)count++;
            }
        }
     return count;
    }
}