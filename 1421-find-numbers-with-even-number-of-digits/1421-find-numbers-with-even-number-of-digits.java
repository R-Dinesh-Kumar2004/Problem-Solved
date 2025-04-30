class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if((10 <= nums[i] && nums[i] <= 99) || (1000 <= nums[i] && nums[i] <= 9999) || (nums[i] == 100000)){
                count++;
            }
        }
        return count;
    }
}