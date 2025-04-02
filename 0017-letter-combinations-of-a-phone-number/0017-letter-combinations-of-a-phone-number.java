class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> hm = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
       
       char ch[] = digits.toCharArray();
       int n = ch.length;
       List<String> ans = new ArrayList<>();

       if(n == 0) return ans;
       rec(0,ch,"",hm,ans);

       return ans;
    }
    public void rec(int idx,char ch[],String s,Map<Character,String> hm,List<String> ans){
        if(s.length() == ch.length){
            ans.add(s);
            return;
        }
        String cur = hm.get(ch[idx]);
        for(int i=0;i<cur.length();i++){
            rec(idx+1,ch,s+cur.charAt(i),hm,ans);
        }
    }
}