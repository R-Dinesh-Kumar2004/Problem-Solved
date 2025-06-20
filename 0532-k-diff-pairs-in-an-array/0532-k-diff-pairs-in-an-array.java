class Solution {
    public int findPairs(int[] nums, int k) {
        if(k == 0){
            int ans = 0;
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int num : nums){
                hm.put(num,hm.getOrDefault(num,0)+1);
                if(hm.get(num) == 2) ans++;
            }
            return ans;
        }
        Arrays.sort(nums);
        Set<Integer> vis = new HashSet<>();
        int ans = 0;

        for(int num : nums){
            if(vis.add(num)){
                if(binarySearch(nums,num+k)) ans++;
            }
        }
        return ans;
    }
    public boolean binarySearch(int nums[],int key){
        int low = 0,high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == key) return true;
            else if(nums[mid]<key) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}