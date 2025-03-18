class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0, left = 0;
        int sum =0, xor = 0;

        for(int right=0;right<n;right++){
            int val = nums[right];
            sum += val;
            xor ^= val;

            while(sum != xor){
                sum -= nums[left];
                xor ^= nums[left];
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}