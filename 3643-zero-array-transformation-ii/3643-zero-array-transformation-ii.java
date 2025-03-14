class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = -1;
        int high = queries.length-1;
        int low = 0;

        if(isValid(queries,nums,-1)) return 0;

        while(low<=high){
            int mid = (low+high)/2;
            if(isValid(queries,nums,mid)){
                ans = mid+1;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public boolean isValid(int queries[][],int nums[],int sz){
        int n = nums.length;
        int temp[] = new int[n];

        for(int i=0;i<=sz;i++){
            int s = queries[i][0], e = queries[i][1], val = queries[i][2];
            temp[s] += val;
            if(e+1<n) temp[e+1] -= val;
        }
        if(nums[0]>temp[0]) return false;
        int sum = temp[0];
        for(int i=1;i<n;i++){
            sum += temp[i];
            if(sum<nums[i]) return false;
            // System.out.print(sum+" ");
        }
        // System.out.println();
        return true;
    }
}