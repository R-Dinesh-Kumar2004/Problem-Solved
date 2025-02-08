class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Set<Integer>> freq = new HashMap<>();

        for(int i=0;i<groupSizes.length;i++){
            int val = groupSizes[i];
            if(!freq.containsKey(val)){
                freq.put(val,new HashSet<>());
                freq.get(val).add(i);
            }
            else freq.get(val).add(i);
        }

        for(Map.Entry<Integer,Set<Integer>> en : freq.entrySet()){
            Set<Integer> hs = en.getValue();
            List<Integer> sub = new ArrayList<>();

            for(int it : hs){
                sub.add(it);
                if(sub.size() == en.getKey()){
                    ans.add(sub);
                    sub = new ArrayList<>();
                }
            }
            // System.out.print(en.getValue());
        }
        return ans;
    }
}