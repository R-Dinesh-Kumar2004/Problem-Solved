/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<sz;i++){
                Node node = q.poll();
                sub.add(node.val);
                for(Node it : node.children){
                    q.add(it);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}