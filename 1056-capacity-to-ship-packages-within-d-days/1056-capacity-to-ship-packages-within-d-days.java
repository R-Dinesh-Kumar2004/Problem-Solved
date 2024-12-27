class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int i:weights){
            high+=i;
            if(i>low) low=i;
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean find(int weights[],int days,int weight){
        int count=0,n=weights.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+weights[i]<=weight){
                sum+=weights[i];
            }
            else{
                sum=weights[i];
                count++;
            }
        }
        if(sum>0) count++;
        return count<=days;
    }
}