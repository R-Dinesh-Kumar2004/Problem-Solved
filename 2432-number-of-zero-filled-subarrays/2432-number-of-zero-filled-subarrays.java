class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int left = 0,right = 0;
        long ans = 0;

        while(right<n){
            while(right<n && nums[right] != 0) right++;
            left = right;

            while(right<n && nums[right] == 0) right++;
            long len = right-left;
            ans += len*(len+1)/2;
        }
        return ans;
    }
}