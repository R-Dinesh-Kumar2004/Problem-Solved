class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n =  nums.length;
        int max = findMaxSum(nums);

        for(int i=0;i<n;i++){
            nums[i] = -1*nums[i];
        }
        int min = findMaxSum(nums);

        return Math.max(max,min);
    }
    public int findMaxSum(int nums[]){
        int max = Integer.MIN_VALUE;
        int curMax = 0;

        for(int val : nums){
            curMax += val;
            max = Math.max(max,curMax);

            if(curMax<0) curMax = 0;
        }
        return max;
    }
}