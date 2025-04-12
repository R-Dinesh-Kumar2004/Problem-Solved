class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low;i<=high;i++){
            int noOfDigits = (int)Math.log10(i)+1;
            if(noOfDigits%2 == 0 && isSymmetric(i)) count++;
        }
        return count;
    }
    public boolean isSymmetric(int num){
        String s = ""+num;
        int n = s.length();
        int sum = 0;

        for(int i=0;i<n;i++){
            if(i<n/2) sum += s.charAt(i)-'a';
            else sum -= s.charAt(i)-'a';
        }
        return sum == 0;
    }
}