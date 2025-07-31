class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int freq[] = new int[26];
        int cur = 0,ans = 0;

        for(char c : croakOfFrogs.toCharArray()){
            if(c == 'c'){
                freq[c-'a']++;
                cur++;
                ans = Math.max(ans,cur);
            }
            else if(c == 'k'){
                freq['c'-'a']--; freq['r'-'a']--; freq['o'-'a']--; freq['a'-'a']--;
                cur--;
            }
            else{
                if(c == 'r'){
                    if(!(freq['c'-'a'] > freq[c-'a'])) return -1;
                }
                else if(c == 'o'){
                    if(!(freq['r'-'a'] > freq[c-'a'])) return -1;
                }
                else if(c == 'a'){
                    if(!(freq['o'-'a'] > freq[c-'a'])) return -1;
                }
                else{
                    if(!(freq['k'-'a'] > freq[c-'a'])) return -1;
                }

                freq[c-'a']++;
            }
        }

        for(int i=0;i<26;i++){
            if(freq[i] != 0) return -1;
        }

        return ans;
    }
}