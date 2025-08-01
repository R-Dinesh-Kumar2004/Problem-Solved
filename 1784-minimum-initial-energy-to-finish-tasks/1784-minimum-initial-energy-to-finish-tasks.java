class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int nums[][] = new int[n][3];
        int idx = 0,low = 0,high = 0;
        for(int task[] : tasks){
            nums[idx][0] = task[0];
            nums[idx][1] = task[1];
            nums[idx++][2] = task[1]-task[0];

            low = Math.max(low,task[1]);
            high += task[1];
        } 
        Arrays.sort(nums,(a,b)->{
            if(a[2] == b[2]){
                return b[1]-a[1];
            }
            return b[2]-a[2];
        });

        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isValid(nums,mid,n)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }
    public boolean isValid(int nums[][],int energy,int n){
        for(int i=0;i<n;i++){
            if(energy >= nums[i][1]){
                energy -= nums[i][0];
            }
            else return false;
        }
        return true;
    }
}