class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int val = nums[i]*nums[j];
                hm.put(val,hm.getOrDefault(val,0)+1);
            }
        }

        int ans = 0;
        for(int i:hm.values()){
            if(i>1){
                int ways = (i*(i-1))/2;
                ans+=ways*8; 
            }
        }
        return ans;
    }
}