class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int sumArr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0){
                    sumArr[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                else if(matrix[i][j] == '1'){
                    sumArr[i][j] = 1 + sumArr[i-1][j];
                }
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,findMaxArea(sumArr[i]));
        }

        return ans;
    }
    public int findMaxArea(int sumArr[]){
       int n = sumArr.length;
       int prevSmall[] = findPrevSmallest(sumArr,n);
       int nextSmall[] = findNextSmallest(sumArr,n);

       int maxArea = 0;
       for(int i=0;i<n;i++){
           int width = nextSmall[i]-prevSmall[i]-1;
           maxArea = Math.max(maxArea,width*sumArr[i]);
       }

       return maxArea;
    }
    public int[] findPrevSmallest(int nums[],int n){
        int prevSmall[] = new int[n];
        int st[] = new int[n];
        int top = -1;

        for(int i=0;i<n;i++){
            int val = nums[i];
            while(top>=0 && nums[st[top]] >= val) top--;

            if(top>=0){
                prevSmall[i] = st[top];
            }
            else prevSmall[i] = -1;

            st[++top] = i;
        }

        return prevSmall;
    }
    public int[] findNextSmallest(int nums[],int n){
        int nextSmall[] = new int[n];
        int st[] = new int[n];
        int top = -1;

        for(int i=n-1;i>=0;i--){
            int val = nums[i];

            while(top>=0 && nums[st[top]] >= val) top--;

            if(top>=0){
                nextSmall[i] = st[top];
            }
            else{
                nextSmall[i] = n;
            }

            st[++top] = i;
        }

        return nextSmall;
    }
}