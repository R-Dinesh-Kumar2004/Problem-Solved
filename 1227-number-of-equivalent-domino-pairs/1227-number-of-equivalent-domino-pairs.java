class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> hm = new HashMap<>();

        for(int it[] : dominoes){
            if(it[0]>it[1]){
                int t = it[0];
                it[0] = it[1];
                it[1] = t;
            }
            String s = it[0]+""+it[1];
            hm.putIfAbsent(s,0);
            hm.put(s,hm.get(s)+1);
        }

        int count = 0;
        for(Map.Entry<String,Integer> en : hm.entrySet()){
            int pair = en.getValue();
            count += (pair*(pair-1)/2);
        }
        return count;
    }
}