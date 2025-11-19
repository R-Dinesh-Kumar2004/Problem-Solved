class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        while(true){
            if(binarySearch(nums,original)){
                original *= 2;
            }
            else break;
        }
        return original;
    }
    public boolean binarySearch(int nums[],int key){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == key) return true;
            else if(nums[mid] < key) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}