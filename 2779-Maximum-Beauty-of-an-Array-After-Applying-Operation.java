class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int arr[]=new int[max+k+2];
        for(int i:nums){
            if(i-k>0){
                arr[i-k]+=1;
            }
            else arr[0]+=1;
            arr[i+k+1]-=1;
        }
        int sum=0;max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(max<sum){
                max=sum;
            }
        }
        return max;
    }
}