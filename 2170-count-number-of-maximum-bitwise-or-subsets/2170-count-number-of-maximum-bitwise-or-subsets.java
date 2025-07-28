class Solution {
    int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for(int val : nums){
            target |= val;
        }
        helper(0,0,nums,target);

        return ans;
    }
    public void helper(int idx,int xor,int nums[],int target){
        if(idx == nums.length){
            ans += (xor == target) ? 1 : 0;
            return;
        }

        helper(idx+1,xor|nums[idx],nums,target);
        helper(idx+1,xor,nums,target);
    }
}