class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0,ans = 0,count = 0;

        for(int i=0;i<n;i++){
            if(nums[i] == 0) count++;

            while(count > 1){
                if(nums[left] == 0) count--;
                left++;
            }
            ans = Math.max(ans,i-left);
        }
        return ans;
    }
}