class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int ans = 0;

        for(int right=0;right<n;right++){
            while(left<=right && nums[right]-nums[left]>1) left++;
            if(nums[right]-nums[left] == 1 ) ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}