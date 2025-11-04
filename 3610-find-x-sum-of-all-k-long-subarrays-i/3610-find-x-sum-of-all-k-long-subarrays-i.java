class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int freq[] = new int[51];

        for(int i=0;i<k;i++){
            freq[nums[i]]++;
        }

        ans[0] = findVal(freq,x);

        for(int i=k;i<n;i++){
            freq[nums[i-k]]--;
            freq[nums[i]]++;
            ans[i-k+1] = findVal(freq,x);
        }

        return ans;
    }
    public int findVal(int freq[],int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        for(int i=1;i<51;i++){
            if(freq[i] != 0){
                pq.add(new int[]{freq[i],i});

                if(pq.size() > k) pq.poll();
            }
        }

        System.out.println();
        
        int ans = 0;
        while(!pq.isEmpty()){
            int top[] = pq.poll();
            ans += (top[0]*top[1]);
            // System.out.println(top[0]+" "+top[1]);
        }
        // System.out.println();
        return ans;
    }
}