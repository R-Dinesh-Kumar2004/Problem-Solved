class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int x=0;

        for(int i=0;i<n-1;i++){
            if(nums[i]-nums[i+1]>0){
                x = i+1; break;
            }
        }
        int correct[] = new int[n];
        for(int i=0;i<n;i++){
            correct[i] = nums[(i+x)%n];
            // System.out.print(correct[i]+" ");
        }
        for(int i=1;i<n;i++){
            if(correct[i-1]>correct[i]) return false;
        }
        return true;
    }
}