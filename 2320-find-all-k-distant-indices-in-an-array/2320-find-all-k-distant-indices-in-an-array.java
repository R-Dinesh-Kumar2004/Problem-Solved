class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean vis[] = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i] == key){
                //front 
                int step = k;
                for(int j = i;j>=0 && step>=0;j--){
                    if(!vis[j]) vis[j] = true;
                    // else break;
                    step--;
                }
                //back
                step = k;
                for(int j=i+1;j<n && step>0;j++){
                    if(!vis[j]) vis[j] = true;
                    // else break;
                    step--;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]) ans.add(i);
        }
        return ans;
    }
}