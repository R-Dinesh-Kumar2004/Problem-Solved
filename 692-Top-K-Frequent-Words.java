class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hm=new HashMap<>();
        for(String s:words){
            if(hm.containsKey(s)){
                hm.put(s,hm.get(s)+1);
            }else hm.put(s,1);
        }
        List<String> li=hm.entrySet()
        .stream()
        .sorted((a,b)->{
            if(b.getValue().equals(a.getValue())){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue()-a.getValue();
        }).map(Map.Entry::getKey).toList();
        return li.subList(0,k);
    }
}