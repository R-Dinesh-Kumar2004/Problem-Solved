class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        int left=0,top=0,right=n-1;
        while(left<=right && top<m){
            if(mat[top][right]==target) return true;
            else if(mat[top][left]<=target && target<=mat[top][right]){
                right--;
            }
            else{
                top++;
            }
            // System.out.println(top+" "+left+" "+top+" "+right);
        }
        return false;
    }
}