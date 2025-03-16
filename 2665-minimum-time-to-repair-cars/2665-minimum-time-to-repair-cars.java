class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = Arrays.stream(ranks).max().getAsInt();
        long low = 0,high = (long)cars*cars*max;
        long ans = 0;

        while(low<=high){
            long mid = low+(high-low)/2;
            if(isValid(ranks,mid,cars)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public boolean isValid(int ranks[],long time,int cars){
        int count = 0;

        for(int it : ranks){
            double val = (double)time/it;
            count += Math.sqrt(val);

            if(count>=cars) return true;
        }
        return false;
    }
}