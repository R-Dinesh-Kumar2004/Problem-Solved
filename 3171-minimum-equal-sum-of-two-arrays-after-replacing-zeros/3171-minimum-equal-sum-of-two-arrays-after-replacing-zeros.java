class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0,sum2 = 0;
        int zero1 = 0,zero2 = 0;
        for(int i : nums1){
            sum1 += i;
            if(i == 0){
               sum1++; zero1++;
            } 
        }
        for(int i : nums2){
            sum2 += i;
            if(i == 0){
                sum2++; zero2++;
            }
        }
        if(sum1>sum2 && zero2 == 0) return -1;
        else if(sum2>sum1 && zero1 ==0) return -1;
        // System.out.println(sum1+" "+sum2);
        return Math.max(sum1,sum2);
    }
}