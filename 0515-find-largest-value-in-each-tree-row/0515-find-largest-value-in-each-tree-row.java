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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return li;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            int max=-2147483648;
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);

                if(max<t.val)max=t.val;
            }
            li.add(max);
        }
        return li;
    }
}