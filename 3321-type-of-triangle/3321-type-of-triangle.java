class Solution {
    public String triangleType(int[] nums) {
        if(nums[0]+nums[1]<=nums[2] || nums[1]+nums[2]<=nums[0] || nums[0]+nums[2]<=nums[1]) return "none";
        int freq[] = new int[101];
        int count = 0;
        for(int i : nums){
            if(freq[i]++ == 0) count++;
        }
        if(count == 1) return "equilateral";
        else if(count == 2) return "isosceles";
        return "scalene";
    }
}