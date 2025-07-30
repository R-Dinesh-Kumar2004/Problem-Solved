class Solution {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        int count = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != max){
                ans = Math.max(ans,count);
                count = 0;
            }
            else{
                count++;
            }
        }
        ans = Math.max(ans,count);
        
        return ans;
    }
}