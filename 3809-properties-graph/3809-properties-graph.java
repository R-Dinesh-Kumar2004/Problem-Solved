class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(intersect(properties[i],properties[j])>=k){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[n];
        int cComponent = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                cComponent++;
            }
        }
        return cComponent;
    }
    public int intersect(int arr1[],int arr2[]){
        Map<Integer,Boolean> hm = new HashMap<>();
        for(int i : arr1){
            hm.put(i,false);
        }
        int count = 0;
        
        for(int i : arr2){
            if(!hm.getOrDefault(i,true)){
                count++;
                hm.put(i,true);
            }
        }
        return count;
    }
    public void dfs(int nd,List<List<Integer>> adj,boolean vis[]){
        vis[nd] = true;
        for(int it : adj.get(nd)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
     }
}