class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int l=1,r=position[n-1];
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(position,mid,m)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public static boolean isValid(int arr[],int diff,int b){
        int n=arr.length;
        int last=arr[0];
        for(int i=1;i<n;i++){
            int val=arr[i];
            if(val-last>=diff){
                last=val;
                b--;
            }
            if(b==1) return true;
        }
        // System.out.print(diff+" ");
        return false;
    }
}