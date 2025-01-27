class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indeg[] = new int[numCourses];
        for(int it[]:prerequisites){
            adj.get(it[0]).add(it[1]);
            indeg[it[1]]++;
        }
        List<Set<Integer>> course = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            course.add(new HashSet<>());
        }

        for(int i=0;i<numCourses;i++){
            if(indeg[i] == 0){
                dfs(i,adj,course,new HashSet<>());
            }
        }
        
        // for(Set<Integer> s:course){
        //     System.out.println(s);
        // }
        List<Boolean> ans = new ArrayList<>();
        for(int q[]:queries){
            boolean val = course.get(q[0]).contains(q[1]);
            ans.add(val);
        }
        return ans;
    }
    public void dfs(int nd,List<List<Integer>> adj,List<Set<Integer>> course, Set<Integer> sub){
        for(int it:adj.get(nd)){
            if(course.get(it).size()!=0){
                course.get(nd).addAll(course.get(it));
                course.get(nd).add(it);
                continue;
            }
            dfs(it,adj,course,sub);
            course.get(nd).addAll(course.get(it));
            course.get(nd).add(it);
        }
        // course.get(nd).addAll(sub);
        // sub.add(nd);
        // System.out.println(sub);
    }
}