class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int count=1,max=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]) count++;
            else count = 1;
            max = Math.max(max,count);
        }
        count = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]) count++;
            else count = 1;
            max = Math.max(max,count);
        }
        return max;
    }
}