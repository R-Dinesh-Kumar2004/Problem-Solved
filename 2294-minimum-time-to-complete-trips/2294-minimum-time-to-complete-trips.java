class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 0, high = Long.MAX_VALUE,low = 0;
        for(int it : time) high = Math.min(high,it);

        high *= totalTrips;
        // System.out.print(high);
        while(low<=high){
            long mid = low+(high-low)/2;
            if(isValid(time,mid,totalTrips)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public boolean isValid(int arr[],long time,int totalTrip){
        // System.out.println(time);
        long count = 0;
        for(int it : arr){
            count += time/it;
            if(count >= totalTrip) return true;
        }
        return false;
    }
}