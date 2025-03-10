class Solution {
    public long countOfSubstrings(String word, int k) {
        char ch[] = word.toCharArray();
        long f = find(ch,k);
        long s = find(ch,k+1);
        // System.out.print(f+" "+s);
        return f-s;
    }
    public long find(char ch[],int k){
        int n = ch.length;
        int vow[] = new int[26];
        long ans = 0;
        int cons = 0,left = 0;

        for(int right=0;right<n;right++){
            if(!isVowel(ch[right])) cons++;
            else vow[ch[right]-'a']++;

            while(isValid(vow) && cons >= k){
                ans += n-right;
                if(!isVowel(ch[left])) cons--;
                else vow[ch[left]-'a']--;
                left++;
            }
        }
        return ans;
    }
    public boolean isValid(int arr[]){
        return (arr[0] != 0 && arr[4] != 0 && arr[8] != 0 && arr[14] != 0 && arr[20] != 0);
    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}