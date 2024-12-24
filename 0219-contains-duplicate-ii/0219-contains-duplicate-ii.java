class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        k+=1;
        Map<Integer,Integer> hm = new HashMap<>();
        int i=0,range=Math.min(k,n);
        for(i=0;i<range;i++){
            int val=nums[i];
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        if(i!=hm.size()) return true;
        for(i=k;i<n;i++){
            int del=nums[i-k];
            if(hm.get(del)>1) hm.put(del,hm.get(del)-1);
            else hm.remove(del);

            int val=nums[i];
            if(hm.containsKey(val))return true;
            else hm.put(val,1);
        }
        return false;
    }
}