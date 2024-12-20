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
    public void flatten(TreeNode root) {
        if(root==null)return;
        int n=countNode(root);
        TreeNode arr[]=new TreeNode[n];
        preOrder(root,arr,new int[]{0});
        TreeNode prev=arr[0];
        prev.left=null;
        for(int i=1;i<n;i++){
            prev.right=arr[i];
            arr[i].left=null;
            prev=arr[i];
        }
    }
    public int countNode(TreeNode root){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;

        int left=countNode(root.left);
        int right=countNode(root.right);

        return left+right+1;
    } 
    public void preOrder(TreeNode root,TreeNode arr[],int i[]){
        if(root!=null){
            arr[i[0]++]=root;
            preOrder(root.left,arr,i);
            preOrder(root.right,arr,i);
        }
    }
}