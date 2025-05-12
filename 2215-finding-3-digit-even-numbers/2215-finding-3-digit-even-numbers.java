class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Arrays.sort(digits);
        int arr[] = new int[1000];
        int len = 0;

        for(int i=0;i<n;i++){
            int first = digits[i];
            if(first == 0 || (i>0 && digits[i-1] == first)) continue;
            for(int j=0;j<n;j++){
                if(i == j) continue;
                int second = first*10+digits[j];
                for(int k=0;k<n;k++){
                    if(i == k || j == k || digits[k]%2 != 0) continue;
                    int third = second*10+digits[k];
                    if(arr[third]++ == 0) len++;
                }
            }
        }
        int ans[] = new int[len];
        int idx = 0;
        for(int i=100;i<1000;i++){
            if(arr[i] != 0){
                ans[idx++] = i;
            }
        }
        return ans;
    }
}