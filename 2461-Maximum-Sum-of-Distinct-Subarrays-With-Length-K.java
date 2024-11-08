class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0,curr=0;
        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++){
            int a=nums[i];
            curr+=a;
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        max=(hm.size()==k)?curr:0;

        for(int i=k;i<n;i++){
            int add=nums[i];
            hm.put(add,hm.getOrDefault(add,0)+1);
            int del=nums[i-k];
            if(hm.getOrDefault(del,0)>1){
                hm.put(del,hm.get(del)-1);
            }
            else hm.remove(del);

            curr+=add-del;

            if(hm.size()==k){
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}