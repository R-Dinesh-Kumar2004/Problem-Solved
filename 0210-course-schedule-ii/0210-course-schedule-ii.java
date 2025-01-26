class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int indeg[] = new int[numCourses];
        for(int it[]:prerequisites){
            adj.get(it[1]).add(it[0]);
            indeg[it[0]]++;
        }
        int cOrder[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cOrder[i++] = node;
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        // for(List<Integer> l:adj){
        //     System.out.println(l);
        // }
        if(i!=numCourses) return new int[0];
        return cOrder;
    }
}