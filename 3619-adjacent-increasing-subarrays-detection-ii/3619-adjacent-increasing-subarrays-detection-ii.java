class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int curr=1,prev=0;
        int n=nums.size();
        int max=0;
        for(int i=0;i<n;i++){
            if(i>0 && nums.get(i)>nums.get(i-1))curr++;
            else{ 
                prev=curr;
                max=Math.max(max,curr/2);
                curr=1;
            }
            max=Math.max(max,Math.min(prev,curr));
        }
        max=Math.max(max,curr/2);
        return max;
    }
}