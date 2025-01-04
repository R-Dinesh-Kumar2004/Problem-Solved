class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count=0;
        boolean visited[] = new boolean[26];
        for(int i=0;i<n;i++){
            int j=n-1;
            char c=s.charAt(i);
            while(i<j && !visited[c-'a']){
                if(c==s.charAt(j)){
                    count+=countU(s,i+1,j-1);
                    visited[c-'a']=true;
                }
                j--;
            }
        }
        return count;
    }
    public static int countU(String str,int s,int e){
        int freq[] = new int[26];
        int count=0;
        for(int i=s;i<=e;i++){
            char c=str.charAt(i);
            if(freq[c-'a']==0){
                count++;
                freq[c-'a']=1;
            }
        }
        return count;
    }
}