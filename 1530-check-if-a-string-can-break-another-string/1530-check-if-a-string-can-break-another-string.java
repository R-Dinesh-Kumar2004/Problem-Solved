class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        int count = 0;

        for(int i=0;i<n;i++){
            if(ch1[i] >= ch2[i]) count++;
        }

        if(count == n) return true;
        count = 0;

        for(int i=0;i<n;i++){
            if(ch1[i] <= ch2[i]) count++;
        }

        return count == n;
    }
}