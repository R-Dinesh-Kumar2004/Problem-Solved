class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][]=new int[n][n];
        int v=0;
        int top=0,left=0,right=n-1,bot=n-1;
        while(left<=right && top<=bot){
            for(int i=left;i<=right;i++)arr[top][i]=(++v);
            top++;
            for(int i=top;i<=bot;i++)arr[i][right]=(++v);
            right--;
            if(top<=bot){
               for(int i=right;i>=left;i--)arr[bot][i]=(++v);
               bot--;
            }
            if(left<=right){
               for(int i=bot;i>=top;i--)arr[i][left]=(++v);
               left++;
            } 
        }
        return arr;
    }
}