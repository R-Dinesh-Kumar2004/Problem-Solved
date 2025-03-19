class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=2;i<n;i++){
           if(nums[i-2] == 0){
               count++;
               nums[i-2] ^= 1;
               nums[i-1] ^= 1;
               nums[i] ^= 1;
           }
        }

        if(nums[n-1] == 0 || nums[n-2] == 0) return -1;

        return count;
    }
}