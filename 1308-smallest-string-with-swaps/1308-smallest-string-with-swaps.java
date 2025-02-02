class Solution {
    public String smallestStringWithSwaps(String str, List<List<Integer>> pairs) {
        int n = str.length();
        int parent[] = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        char ch[] = str.toCharArray();

        for(List<Integer> l:pairs){
            int s = l.get(0);
            int d = l.get(1);
            int p1 = findParent(s,parent);
            int p2 = findParent(d,parent);

            if(p1!=p2){
                parent[p2] = p1;
            } 
        }
        Map<Integer,Integer> hm = new HashMap<>();
        int gId = 0;
        for(int i:parent){
            int p = findParent(i,parent);
            if(!hm.containsKey(p)){
                hm.put(p,gId); gId++;
            }
        }

        List<PriorityQueue<Character>> com = new ArrayList<>();
        for(int i=0;i<=gId;i++){
            com.add(new PriorityQueue<>((a,b)->a-b));
        }
        
        for(int i=0;i<n;i++){
            int p = findParent(i,parent);
            int id = hm.get(p);
            com.get(id).add(ch[i]);
        }
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<n;i++){
            int p = findParent(i,parent);
            int id = hm.get(p);
            char c = com.get(id).poll();
            sb.append(c);
        }

        return sb.toString();
    }
    public int findParent(int nd,int parent[]){
        if(parent[nd] == nd){
            return nd;
        }
        return parent[nd] = findParent(parent[nd],parent);
    }
}