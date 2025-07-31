class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int st[] = new int[n];
        int top = -1;

        int ans[] = new int[n];

        for(int i=2*n-1;i>=0;i--){
            int val = nums[i%n];
            while(top>=0 && st[top]<=val) top--;

            if(i<n){
                if(top>=0) ans[i] = st[top];
                else ans[i] = -1;
            }

            st[++top] = val;
        }

        return ans;
    }
}