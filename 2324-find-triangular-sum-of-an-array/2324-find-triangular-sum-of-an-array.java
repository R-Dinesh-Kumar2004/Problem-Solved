class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n-1;i++){
            int temp[] = new int[nums.length-1];
            int size=temp.length;
            for(int j=0;j<size;j++){
                temp[j]=(nums[j]+nums[j+1])%10;
            }
            nums=temp;
        }
        return nums[0];
    }
}