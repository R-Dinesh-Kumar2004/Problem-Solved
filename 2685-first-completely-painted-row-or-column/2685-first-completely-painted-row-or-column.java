class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length;
        int idx[] = new int[n+1]; 
        for(int i=0;i<n;i++){
            idx[arr[i]] = i;
        }  
        int rowMin = n;
        for(int i[]:mat){
            int max=0;
            for(int j:i){
                max=Math.max(max,idx[j]);
            }
            rowMin = Math.min(rowMin,max);
        }
        int r = mat.length, c = mat[0].length;
        int colMin = n;
        for(int i=0;i<c;i++){
            int max = 0;
            for(int j=0;j<r;j++){
                max = Math.max(max,idx[mat[j][i]]);
            }
            colMin = Math.min(colMin,max);
        }
        return Math.min(rowMin,colMin);
    }
}