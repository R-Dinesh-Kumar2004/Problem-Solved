class Solution {
    public int minOperations(int[] nums, int k) {
        int freq[] = new int[101];
        int count = 0,min = 101;
        for(int i : nums){
            if(i>k && freq[i]++ == 0) count++;
            if(min>i) min = i;
        }
        if(min<k) return -1;
        return count;
    }
}