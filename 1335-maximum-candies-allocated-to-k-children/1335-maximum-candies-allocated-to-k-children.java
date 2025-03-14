class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int high = 0,low = 1,ans = 0;
        for(int it : candies){
            sum += it;
            high = Math.max(high,it);
        } 
        if(sum<k) return 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(isValid(candies,mid,k)){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
    public boolean isValid(int candies[],int candy,long k){
        long count = 0;

        for(int it : candies){
            count += (it/candy);
            if(count>=k) return true;
        }
        return false;
    }
}