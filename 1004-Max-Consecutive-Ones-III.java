class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0,max=0;
        int left=0,right=0;
        int n=nums.length;
        for(right=0;right<n;right++){
            if(nums[right]==0)zero++;
            while(zero>k){
                max=Math.max(max,right-left);
                if(nums[left]==0)zero--;
                left++;
            }
        }
        max=Math.max(max,right-left);
        return max;
    }
}