class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int pre[] = new int[n+1];
        for(int i=0;i<n;i++){
            int cnt=countVowels(words[i]);
            pre[i+1]=pre[i]+cnt;
            // System.out.print(pre[i+1]+" ");
        }
        int idx=0;
        int ans[] = new int[queries.length];
        for(int i[]:queries){
            int tot=pre[i[1]+1]-pre[i[0]];
            ans[idx++]=tot;
        }
        return ans;
    }

    public static int countVowels(String s){
        int n=s.length();
        if(isVowel(s.charAt(0)) && isVowel(s.charAt(n-1))) return 1;
        return 0;
    }

    public static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}