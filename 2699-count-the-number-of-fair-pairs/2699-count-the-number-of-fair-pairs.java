class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            int lb = lowerBound(nums,i+1,n-1,lower-nums[i]);
            int up = upperBound(nums,i+1,n-1,upper-nums[i]);
            ans += (up-lb);
        }
        return ans;
    }
    public int lowerBound(int nums[],int low,int high,int num){
        int ans = high+1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=num){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int upperBound(int nums[],int low,int high,int num){
        int ans = high+1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]>num){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}