class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> hs = new HashSet<>();
        for(int i=0;i<n-3;i++){
            int num1 = nums[i];
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                int num2 = nums[j];
                int low = j+1,high = n-1;
                while(low<high){
                    long sum = (long)num1+num2+nums[low]+nums[high];
                    if(sum == target){
                        List<Integer> li = new ArrayList<>();
                        li.add(num1); li.add(num2); li.add(nums[low]); li.add(nums[high]);
                        hs.add(li);
                        low++; high--;
                    }
                    else if(sum<target) low++;
                    else high--;
                }
            }
        }
        return new ArrayList<>(hs);
    }
}