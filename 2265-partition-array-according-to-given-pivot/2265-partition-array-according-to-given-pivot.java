class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        int count = 0;
        
        int n = nums.length;
        int ans[] = new int[n];

        for(int it : nums){
            if(pivot>it) min.add(it);
            else if(pivot<it) max.add(it);
            else count++;
        }
        int idx = 0;
        for(int it : min){
            ans[idx++] = it;
        }
        while(count-->0) ans[idx++] = pivot;
        for(int it : max){
            ans[idx++] = it;
        }
        // System.out.print(min);
        return ans;
    }
}