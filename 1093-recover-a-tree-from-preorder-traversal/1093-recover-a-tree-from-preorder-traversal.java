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
        int depth;
        Pair(TreeNode node,int d){
            this.node = node;
            this.depth = d;
        }
    }
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<Pair> st = new Stack<>();
        int depthCount = 0, n = traversal.length();
        
        int idx = 0;
        while(idx<n){
            while(traversal.charAt(idx) == '-'){
                depthCount++;
                idx++;
            } 
            StringBuffer sb = new StringBuffer();
            while(idx<n && Character.isDigit(traversal.charAt(idx))){
                sb.append(traversal.charAt(idx)); idx++;
            }

            int val = Integer.parseInt(sb.toString());

            if(st.isEmpty()){
                st.push(new Pair(new TreeNode(val),depthCount));
            }
            else{
                while(st.peek().depth >= depthCount) st.pop();
                Pair p = st.peek();
                TreeNode node = p.node;

                if(node.left == null){
                    node.left = new TreeNode(val);
                    st.push(new Pair(node.left,depthCount));
                }  
                else{
                    node.right = new TreeNode(val);
                    st.push(new Pair(node.right,depthCount));
                }             
            }
            depthCount = 0;
        }
        TreeNode root = st.get(0).node;
        return root;
    }
}