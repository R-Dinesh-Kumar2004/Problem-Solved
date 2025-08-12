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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode newNode = new TreeNode(val);

        if(node == null) return newNode;

        while(node != null){
            if(val < node.val){
                if(node.left == null){
                    node.left = newNode;
                    return root;
                }
                else{
                    node = node.left;
                }
            }
            else{
                if(node.right == null){
                    node.right = newNode;
                    return root;
                }
                else{
                    node = node.right;
                }
            }
        }

        return root;
    }
}