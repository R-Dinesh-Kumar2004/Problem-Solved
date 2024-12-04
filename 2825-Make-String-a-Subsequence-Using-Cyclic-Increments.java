class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        if(l2>l1)return false;

        int i=0,j=0;
        while(i<l1 && j<l2){
            char c1=str1.charAt(i);
            char c2=str2.charAt(j);
            if(c1==c2 || c1+1==c2){
                j++;
            }
            else if(c1=='z' && c2=='a')j++;
            i++;
        }
        return j>=l2;
    }
}