class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> li=new ArrayList<>();
        int n=s.length();
        if(n<=10)return li;

        Map<String,Integer> hm=new HashMap<>();
        int i=0;
        for(int j=10;j<=n;j++){
            String str=s.substring(i,j);
            hm.put(str,hm.getOrDefault(str,0)+1);
            i++;
        }
        // System.out.println(hm);
        for(Map.Entry<String,Integer> en:hm.entrySet()){
            if(en.getValue()>1)li.add(en.getKey());
        }
        return li;
    }
}