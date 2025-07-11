class Solution {
    int st[][];
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        int visCount[] = new int[n];

        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        for(int i=0;i<n;i++) availableRoom.add(i);

        PriorityQueue<int[]> allocated = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        for(int it[] : meetings){
            int s = it[0],e = it[1];

            while(!allocated.isEmpty() && allocated.peek()[0]<=s){
                int newFree = allocated.peek()[1];
                allocated.poll();
                availableRoom.add(newFree);
            }

            if(!availableRoom.isEmpty()){
                int roomNo = availableRoom.poll();
                visCount[roomNo]++;
                allocated.add(new int[]{e,roomNo});
            }
            else{
                int duration = e-s;
                int top[] = allocated.poll();
                int end = top[0], roomNo = top[1];

                visCount[roomNo]++;
                allocated.add(new int[]{end+duration,roomNo}); 
            }
        }

        int ans = 0,val = 0;
        for(int i=0;i<n;i++){
            if(val<visCount[i]){
                val = visCount[i];
                ans = i;
            }
        }

        return ans;
        
    //     st = new int[4*n][2];
    //     build(0,n-1,0);
    //     int numberOfMeeting[] = new int[n];

    //     for(int meet[] : meetings){
    //         int s = meet[0];
    //         int e = meet[1];

    //         int curRoom = st[0][0];
    //         numberOfMeeting[curRoom]++;

    //         int duration = e-s;
    //         int newFree = Math.max(st[0][1],s)+duration;
    //         update(0,n-1,0,curRoom,newFree);
    //     }

    //     int ans = 0,val = 0;
    //     for(int i=0;i<n;i++){
    //         if(val<numberOfMeeting[i]){
    //             val = numberOfMeeting[i];
    //             ans = i;
    //         }
    //     }

    //     return ans;
    // }

    // public void build(int low,int high,int idx){
    //     if(low == high){
    //         st[idx][0] = low;
    //         return; 
    //     }
    //     int mid = (low+high)/2;
    //     build(low,mid,2*idx+1);
    //     build(mid+1,high,2*idx+2);

    //     if(st[2*idx+1][1]>st[2*idx+2][1]){
    //         st[idx][0] = st[2*idx+2][0];
    //         st[idx][1] = st[2*idx+2][1];
    //     }
    //     else{
    //         st[idx][0] = st[2*idx+1][0];
    //         st[idx][1] = st[2*idx+1][1];
    //     }
    // }

    // public void update(int low,int high,int idx,int up,int val){
    //     if(low == high){
    //         st[idx][1] = val;
    //         return;
    //     }

    //     int mid = (low+high)/2;
    //     if(up<=mid) 
    //         update(low,mid,2*idx+1,up,val);
    //     else 
    //         update(mid+1,high,2*idx+2,up,val);

    //     if(st[2*idx+1][1]>st[2*idx+2][1]){
    //         st[idx][0] = st[2*idx+2][0];
    //         st[idx][1] = st[2*idx+2][1];
    //     }
    //     else{
    //         st[idx][0] = st[2*idx+1][0];
    //         st[idx][1] = st[2*idx+1][1];
    //     }
    }
}