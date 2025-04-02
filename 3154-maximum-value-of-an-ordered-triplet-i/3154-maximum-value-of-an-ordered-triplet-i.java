class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long max = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                long sum = nums[i] - nums[j];
                for(int k=j+1;k<n;k++){
                    max = Math.max(max,sum*nums[k]);
                }
            }
        }
        return max;
    }
}