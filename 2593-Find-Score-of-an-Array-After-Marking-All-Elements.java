class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[2]-b[2];
            }
            return a[0]-b[0];
        });
        pq.offer(new int[]{nums[0],-1,0,1});
        pq.offer(new int[]{nums[n-1],n-2,n-1,-1});
        for(int i=1;i<n-1;i++){
            pq.offer(new int[]{nums[i],i-1,i,i+1});
        }
        long sum=0;
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int val=arr[0],prev=arr[1],curr=arr[2],next=arr[3];
            if(nums[curr]!=-1){
               sum+=val;
               if(prev!=-1)nums[prev]=-1;
               if(next!=-1)nums[next]=-1;
            }
        } 
        return sum;
    }
}