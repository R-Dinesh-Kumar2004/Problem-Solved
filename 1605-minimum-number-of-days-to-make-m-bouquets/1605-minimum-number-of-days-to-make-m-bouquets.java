class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<m*k) return -1;
        int low=1000000000,high=0;
        for(int i:bloomDay){
            if(i>high) high=i;
            if(i<low) low=i;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int arr[],int day,int m,int k){
        int count=0,noOfB=0;
        for(int i:arr){
            if(i<=day)count++;
            else{
                noOfB+=(count/k);
                count=0;
            }
            if(noOfB>=m) return true;
        }
        noOfB+=(count/k);
        return noOfB>=m;
    }
}