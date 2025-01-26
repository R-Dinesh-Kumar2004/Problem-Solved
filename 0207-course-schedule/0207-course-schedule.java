class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[numCourses];
        for(int it[]:prerequisites){
            adj.get(it[0]).add(it[1]);
            indegree[it[1]]++;
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