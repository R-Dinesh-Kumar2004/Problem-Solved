class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        String st[] = new String[n];
        int top = -1;

        for(String s : words){

            if(top >= 0 && isAnagram(s,st[top])){
                continue;
            }
            else st[++top] = s;
        }

        List<String> ans = new ArrayList<>();
        for(int i=0;i<=top;i++){
            ans.add(st[i]);
        }

        return ans;
    }
    public boolean isAnagram(String s1,String s2){
        int freq[] = new int[26];
        for(char c : s1.toCharArray()){
            freq[c-'a']++;
        }

        for(char c : s2.toCharArray()){
            freq[c-'a']--;
        }

        for(int i=0;i<26;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}