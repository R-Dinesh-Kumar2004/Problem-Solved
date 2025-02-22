/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int x,y;
        Pair(TreeNode node,int x,int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return verticalOrderTraversal(root);
    }
    public List<List<Integer>> verticalOrderTraversal(TreeNode root){
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int val = node.val, x = p.x, y = p.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());

            map.get(x).get(y).add(val);

            if(node.left != null){
                q.add(new Pair(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Map<Integer,PriorityQueue<Integer>> tm : map.values()){
            List<Integer> l = new ArrayList<>();
            for(PriorityQueue<Integer> pq : tm.values()){
                while(!pq.isEmpty()){
                    l.add(pq.poll());
                }
            }
            ans.add(l);
        }
        return ans;
    }
}