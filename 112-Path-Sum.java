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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return find(root,targetSum);   
    }
    public boolean find(TreeNode root,int target){
        if(root==null)return false;
        target-=root.val;
        if(root.left==null && root.right==null){
            return target==0;
        }

        return find(root.left,target)||find(root.right,target);
    }
}