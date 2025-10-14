class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int a=1,b=1;
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(i>0 && nums.get(i)>nums.get(i-1))a++;
            else a=1;
            if(i+k<n && nums.get(i+k)>nums.get(i+k-1))b++;
            else b=1;
            // System.out.println(a+"  "+b);
            if(a>=k && b>=k)return true;
        }
        return false;
    }
}