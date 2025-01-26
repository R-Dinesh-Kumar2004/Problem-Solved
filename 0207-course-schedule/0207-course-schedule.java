class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int it[]:prerequisites){
            adj.get(it[0]).add(it[1]);
        }
        int indegree[] = new int[numCourses];
        for(List<Integer> l:adj){
            for(int i:l) indegree[i]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }

        for(int i:indegree){
            if(i!=0) return false;
        }

        return true;
    }
}