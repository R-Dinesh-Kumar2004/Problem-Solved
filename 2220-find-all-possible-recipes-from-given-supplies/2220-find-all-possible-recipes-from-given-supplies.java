class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String,List<String>> adj = new HashMap<>();
        Map<String,Integer> indeg = new HashMap<>();

        for(String s : supplies){
            indeg.put(s,0);
        } 

        for(int i=0;i<n;i++){
            String d = recipes[i];
            for(String s : ingredients.get(i)){
                adj.putIfAbsent(s,new ArrayList<>());
                adj.get(s).add(d);
                indeg.put(d,indeg.getOrDefault(d,0)+1);
            }
        }

        Set<String> available = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        for(Map.Entry<String,Integer> en : indeg.entrySet()){
            if(en.getValue() == 0){
                q.add(en.getKey());
            }
        }

        while(!q.isEmpty()){
            String curr = q.poll();
            available.add(curr);
            
            if(adj.get(curr) == null) continue;

            for(String it : adj.get(curr)){
                indeg.put(it,indeg.get(it)-1);

                if(indeg.get(it) == 0){
                    q.add(it);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(String s : recipes){
            if(available.contains(s)) ans.add(s);
        }
        
        return ans;
    }
}