class Solution {
    boolean ans = false;

    public boolean checkPowersOfThree(int n) {
        int pow[] = new int[15];
        for(int i=0;i<15;i++){
            pow[i] = (int)Math.pow(3,i);
        }
        return rec(0,n,pow);
    }
    public boolean rec(int idx,int target,int pow[]){
        if(target == 0){
            return true;
        }
        if(idx>=15) return false;

        if(target>=pow[idx]){
            if(rec(idx+1,target-pow[idx],pow)) return true;
        }
        if(rec(idx+1,target,pow)) return true;

        return false;
    }
}