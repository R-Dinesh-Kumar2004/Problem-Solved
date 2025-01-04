class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=0,high=100001;
        for(int i:nums){
            if(i<low) low=i;
            if(i>high) high=i;
        }
        
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isDivide(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static boolean isDivide(int nums[],int d,int t){
        int count=0;
        for(int i:nums){
            count+=Math.ceil((double)i/d);
            if(count>t) return false;
        }
        return true;
    }
}