class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0,count = 0;
        int ans = 0;
        for(int right=0;right<n;right++){
            if(nums[right] == 0) count++;
            while(count>1){
                if(nums[left] == 0) count--;
                left++;
            }
            ans = Math.max(ans,right-left);
        }
        return ans;
    }
}