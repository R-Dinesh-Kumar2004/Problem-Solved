class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int len = (int)(Math.log10(num));
            if(len%2 != 0) count++;
        }
        return count;
    }
}