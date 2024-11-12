class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Arrays.sort(items,(a,b)->{
        //     if(a[0]!=b[0])return b[1]-a[1];
        //     return a[0]-b[0];
        // });
        Arrays.sort(items, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int n=items.length;
        int max[]=new int[n];
        max[0]=items[0][1];
        for(int i=1;i<n;i++){
            max[i]=Math.max(max[i-1],items[i][1]);
        }
        
        int m=queries.length;
        int ans[]=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=findMax(items,max,queries[i]);
        }
        return ans;
    }
    public int findMax(int items[][],int max[],int limit){
        int low=0,high=items.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(items[mid][0]<=limit){
                low=mid+1;
            }
            else high=mid-1;
        }
        return high>=0?max[high]:0;
    }
}