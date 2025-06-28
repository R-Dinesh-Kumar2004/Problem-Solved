class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int arr[] = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int ans[] = new int[k];
        int idx = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=n-k;i<n;i++){
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                ans[idx++] = nums[i];
                hm.put(nums[i],hm.get(nums[i])-1);

                if(hm.get(nums[i]) == 0) hm.remove(nums[i]);
            }
        }
        return ans;
    }
}