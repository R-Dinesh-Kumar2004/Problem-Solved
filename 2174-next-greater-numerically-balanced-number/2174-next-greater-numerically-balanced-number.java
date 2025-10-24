class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<10000000;i++){
            if(isValid(i)) return i;
        }
        return -1;
    }
    public boolean isValid(int num){
        int freq[] = new int[10];
        while(num > 0){
            freq[num%10]++;
            num /= 10;
        }

        for(int i=0;i<10;i++){
            if(freq[i] == 0) continue;
            if(freq[i] != i) return false;
        }
        return true;
    }
}