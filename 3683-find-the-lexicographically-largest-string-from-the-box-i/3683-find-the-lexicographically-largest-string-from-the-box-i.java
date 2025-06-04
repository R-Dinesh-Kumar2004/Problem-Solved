class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        int k = n-(numFriends-1);

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<k;i++) sb.append(word.charAt(i)); 
        String ans = sb.toString();

        for(int i=k;i<n;i++){
            sb.deleteCharAt(0);
            sb.append(word.charAt(i));
            if(ans.compareTo(sb.toString())<0){
                ans = sb.toString();
            }
        }
        while(sb.length() != 0){
            sb.deleteCharAt(0);
            if(ans.compareTo(sb.toString())<0){
                ans = sb.toString();
            }
        }
        return ans;
    }
}