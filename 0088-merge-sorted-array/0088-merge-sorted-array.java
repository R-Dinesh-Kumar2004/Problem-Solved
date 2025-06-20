class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = (m+n)-1;
        m -= 1;n -= 1;

        while(m>=0 && n>=0){
            if(nums1[m]>nums2[n]){
                nums1[idx--] = nums1[m];
                m--;
            }
            else{
                nums1[idx--] = nums2[n];
                n--;
            }
        }
        while(m>=0){
            nums1[idx--] = nums1[m];
            m--;
        }
        while(n>=0){
            nums1[idx--] = nums2[n];
            n--;
        }
    }
}