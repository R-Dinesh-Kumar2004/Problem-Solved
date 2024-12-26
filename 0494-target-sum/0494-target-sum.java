class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0,nums.length);
    }
    public int rec(int nums[],int target,int i,int n){
        if(i>=n){
            if(target==0) return 1;
            return 0;
        }

        int add=rec(nums,target+nums[i],i+1,n);
        int sub=rec(nums,target-nums[i],i+1,n);

        return add+sub;
    }
}