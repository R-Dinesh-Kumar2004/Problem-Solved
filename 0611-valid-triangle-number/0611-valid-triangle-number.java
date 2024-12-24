class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        if(n<3)return 0;
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int f=nums[i];
            for(int j=i+1;j<n;j++){
                int s=nums[j];
                for(int k=j+1;k<n;k++){
                    if(f+s>nums[k])count++;
                }
            }
        }
        return count;
    }
}