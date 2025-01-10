class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        
        int pre[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=pre[i-1][j]+pre[i][j-1]+mat[i-1][j-1]-pre[i-1][j-1];              
            }
        }
        int low=0,high=Math.min(m,n);
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isValid(pre,threshold,mid)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    public boolean isValid(int pre[][],int t,int r){
        int m=pre.length,n=pre[0].length;
        for(int i=r;i<m;i++){
            for(int j=r;j<n;j++){
                // System.out.print(pre[i][j]+" ");
                int sum=pre[i][j]-pre[i][j-r]-pre[i-r][j]+pre[i-r][j-r];
                if(sum<=t) return true;
            }
            // System.out.println();
        }
        return false;
    }
}