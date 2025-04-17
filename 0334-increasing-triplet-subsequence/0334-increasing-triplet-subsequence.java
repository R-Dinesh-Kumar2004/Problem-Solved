class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int min = nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]>min) pre[i] = 1;
            else min = nums[i];
        }
        int max = nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<max){
                if(pre[i] != 0) return true;
            }
            else max = nums[i];
        }
        return false;
    }
}