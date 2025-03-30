class Solution {
    public List<Integer> partitionLabels(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;

        int last[] = new int[26];
        for(int i=0;i<n;i++){
            last[ch[i]-'a'] = i;
        } 

        List<Integer> ans = new ArrayList<>();
        int left = 0,max = 0;

        for(int right = 0;right<n;right++){
           max = Math.max(last[ch[right]-'a'],max);

           if(max == right){
               int val = right-left+1;
               ans.add(val);
               left = right+1;
           }
        }
        return ans;
    }
}