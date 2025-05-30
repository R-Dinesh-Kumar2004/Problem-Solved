class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]) dq.removeLast();
            dq.addLast(i);

            if(i+1>=k){
                ans[idx++] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}