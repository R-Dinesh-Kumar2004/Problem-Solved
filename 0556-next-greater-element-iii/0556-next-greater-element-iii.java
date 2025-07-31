class Solution {
    public int nextGreaterElement(int n) {
        int nums[] = toArray(n);
        int len = nums.length;
        
        int idx = -1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1) return idx;

        int cIdx = idx+1;
        for(int i=idx+2;i<len;i++){
            if(nums[idx] < nums[i] && nums[cIdx] > nums[i]){
                cIdx = i;
            }
        }

        int t = nums[idx];
        nums[idx] = nums[cIdx];
        nums[cIdx] = t;

        if(idx+2 < len){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=idx+1;i<len;i++){
                pq.add(nums[i]);
            }
            for(int i=idx+1;i<len;i++){
                nums[i] = pq.poll();
            }
        }


        long ans = 0;
        for(int i=0;i<len;i++){
            ans = ans*10+nums[i];
        }

        return (ans > Integer.MAX_VALUE) ? -1 : (int)ans;
    }
    public int[] toArray(int n){
        int len = (int)Math.log10(n)+1;
        int nums[] = new int[len];

        while(n > 0){
            int rem = n%10;
            nums[--len] = rem;
            n /= 10;
        }
        return nums;
    }
}