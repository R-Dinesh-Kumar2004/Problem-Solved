class FindSumPairs {
    HashMap<Integer,Integer> hm1;
    HashMap<Integer,Integer> hm2;
    int nums2[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();
        for(int val : nums1) hm1.put(val,hm1.getOrDefault(val,0)+1);
        for(int val : nums2) hm2.put(val,hm2.getOrDefault(val,0)+1);
        this.nums2 = nums2;
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal+val;
        nums2[index] = newVal;

        hm2.put(oldVal,hm2.get(oldVal)-1);
        if(hm2.get(oldVal) == 0) hm2.remove(oldVal);

        hm2.put(newVal,hm2.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        
        for(Map.Entry<Integer,Integer> en : hm1.entrySet()){
            int num1 = en.getKey();
            int freq1 = en.getValue();

            int num2 = tot-num1;
            int freq2 = hm2.getOrDefault(num2,0);

            count += freq1*freq2;
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */