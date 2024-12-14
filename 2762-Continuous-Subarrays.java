class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        long count=0;
        // window=0;

        for(right=0;right<n;right++){
            int val=nums[right];
            if(max<val)max=val;
            if(min>val)min=val;

            if(max-min>2){
                long window=right-left;
                count+=(window*(window+1)/2);
                left=right;
                min=val;max=val;
                while(Math.abs(nums[right]-nums[left-1])<3){
                    left--;
                    val=nums[left];
                    if(max<val)max=val;
                    if(min>val)min=val;
                }
                
                window=right-left;
                if(window!=0)
                count-=(window*(window+1)/2);
            }
        }
        long win=right-left;
        count+=(win*(win+1)/2);
        return count;
    }
}