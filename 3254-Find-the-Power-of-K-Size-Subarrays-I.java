class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            ans[i]=check(nums,i,i+k-1);
        }
        return ans;
    }

    public int check(int arr[],int start,int end){
        for(int i=start;i<end;i++){
            if(arr[i]+1!=arr[i+1])return -1;
        }
        return arr[end];
    }
}