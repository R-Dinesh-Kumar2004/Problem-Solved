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
        int pos;

        Pair(TreeNode node,int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));

        int ans = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            int left = 0,right = 0;
            for(int i=0;i<sz;i++){
                TreeNode node = q.peek().node;
                int pos = q.peek().pos;
                q.poll();

                if(i == 0) left = pos;
                if(i == sz-1) right = pos;

                if(node.left != null) q.add(new Pair(node.left,2*pos+1));
                if(node.right != null) q.add(new Pair(node.right,2*pos+2)); 
            }
            ans = Math.max(ans,right-left+1);
        }

        return ans;
    }
}