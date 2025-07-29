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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root.left,root,true,target);
        helper(root.right,root,false,target);

        if(root.left == null && root.right == null && root.val == target) return null;
        return root;
    }
    public void helper(TreeNode node, TreeNode parent,boolean isLeft, int target){
        if(node == null) return;
        helper(node.left,node,true,target);
        helper(node.right,node,false,target);

        if(node.left == null && node.right == null && node.val == target){
            if(isLeft) parent.left = null;
            else parent.right = null;
        }
    }
}