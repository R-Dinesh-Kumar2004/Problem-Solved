class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> s=new HashSet<>();
        for(int i:banned){
            s.add(i);
        }

        int count=0,sum=0;
        int range=Math.min(maxSum,n);
        for(int i=1;i<=range;i++){
            if(!s.contains(i)){
                if(sum+i<=maxSum){
                    count++;
                    sum+=i;
                }
                else break;
            }
        }
        return count;
    }
}