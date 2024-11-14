class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            xor^=nums[i];
        }
        int count=0;
        for(int i=0;i<32;i++){
            if((xor&(1<<i))!=(k&(1<<i)))count++;
        }
        return count;
    }
}