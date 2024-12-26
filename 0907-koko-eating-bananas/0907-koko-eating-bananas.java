class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Arrays.stream(piles).max().getAsInt();
        int ans=-1;
        int low=1,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            int val=find(piles,mid);
            if(val<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int find(int arr[],int k){
        int totalTime=0;
        for(int i:arr){
            totalTime+=Math.ceil(i/(k*1.0));
        }
        // System.out.println(totalTime+" "+k);
        return totalTime;
    }
}