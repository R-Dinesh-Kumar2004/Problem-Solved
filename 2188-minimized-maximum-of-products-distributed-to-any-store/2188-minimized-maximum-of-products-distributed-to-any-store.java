class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();

        int ans = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(n,mid,quantities)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }
    public boolean isPossible(int n,int distribute,int quantities[]){
        int count = 0;

        for(int val : quantities){
            count += Math.ceil((double)val/distribute);
            
            if(count > n) return false;
        }

        return true;
    }
}