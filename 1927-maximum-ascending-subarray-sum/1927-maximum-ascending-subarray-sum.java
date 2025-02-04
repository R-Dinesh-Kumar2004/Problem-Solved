class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0],max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                sum+=nums[i];
            }
            else{
                sum = nums[i];
            }
            if(max<sum){
                max = sum;
            }
        }
        return max;
    }
}