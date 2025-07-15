class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n<3) return false;

        boolean vowel = false,consonent = false;

        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if((c>=65 && c<91) || (c>=97 && c<123)){
                if(isVowel(Character.toLowerCase(c))) vowel = true;
                else consonent = true;
            }
            else if(c>=48 && c<=57) continue;
            else return false;
        }
        
        return (vowel & consonent);
    }
    public boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}