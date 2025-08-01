class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(0,nums,new ArrayList<>());

        return new ArrayList<>(ans);
    }
    public void helper(int idx,int nums[],List<Integer> list){
        if(list.size() >= 2){
            ans.add(new ArrayList<>(list));
        }
        if(idx == nums.length) return;
        
        if(list.size() == 0 || list.get(list.size()-1) <= nums[idx]){
            list.add(nums[idx]);
            helper(idx+1,nums,list);
            list.remove(list.size()-1);
        }
        helper(idx+1,nums,list);
    }
}