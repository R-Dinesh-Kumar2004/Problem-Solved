class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long sum=0;
        for(int i:nums) sum+=i;
        int count=0;
        long curr=0;
        for(int i=0;i<n-1;i++){
            int val=nums[i];
            curr+=val;
            sum-=val;
            if(curr>=sum) count++;
        }
         return count;
    }
}