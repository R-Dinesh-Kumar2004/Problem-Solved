class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean primes[] = new boolean[right+1];
        Arrays.fill(primes,true);
        primes[1] = false;

        for(int i=2;i*i<=right;i++){
            if(primes[i]){
                for(int j = i*i;j<=right;j+=i){
                    primes[j] = false;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int last = -1;
        int ans[] = {-1,-1};

        for(int i=left;i<=right;i++){
            if(primes[i]){
                if(last == -1){
                    last = i;
                }
                else{
                    if(min>i-last){
                        min = i-last;
                        ans[0] = last;
                        ans[1] = i;
                    }
                }
                last = i;
            }
        }
        return ans;
    }
}