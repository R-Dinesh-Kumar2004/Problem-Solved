class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        int i = 0;

        for(i=n-1;i>=0;i--){
           if(freq[nums[i]]++ > 0) break;
        }
        int ans = (int)Math.ceil((i+1)/3.0);
        return ans;
    }
}