class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int freq[] = new int[1001];
        int count = 0;
        for(int it[] : nums1){
            if(freq[it[0]] == 0) count++;
            freq[it[0]] += it[1];
        }
        for(int it[] : nums2){
            if(freq[it[0]] == 0) count++;
            freq[it[0]] += it[1];
        }
        int ans[][] = new int[count][2];
        int idx = 0;
        for(int i=1;i<1001;i++){
            if(freq[i] != 0){
                ans[idx][0] = i;
                ans[idx++][1] = freq[i];
            }
        }
        return ans;
    }
}