/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> hm = new HashMap<>();

        for(Employee e1 : employees){
            hm.put(e1.id,e1);
        }
        int ans = hm.get(id).importance;
        Queue<Employee> q = new LinkedList<>();
        for(int sub : hm.get(id).subordinates){
            q.add(hm.get(sub));
        }

        while(!q.isEmpty()){
            Employee e = q.poll();
            ans += e.importance;
           
            for(int sub : hm.get(e.id).subordinates){
                q.add(hm.get(sub));
            }
        }
        return ans;
    }
}