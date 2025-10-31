class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n+1];
        for(int val : nums){
            freq[val]++;
        }

        int ans[] = new int[2];
        int idx = 0;

        for(int i=0;i<=n && idx < 2;i++){
            if(freq[i] == 2){
                ans[idx++] = i;
            }
        }

        return ans;
    }
}