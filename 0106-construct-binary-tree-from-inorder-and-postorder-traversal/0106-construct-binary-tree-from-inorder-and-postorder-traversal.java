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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1,hm);
    }
    public TreeNode helper(int inorder[],int inSt,int inEnd,int postorder[],int pSt,
    Map<Integer,Integer> hm){
        if(inSt > inEnd || pSt < 0) return null;

        TreeNode root = new TreeNode(postorder[pSt]);

        int inPos = hm.get(root.val);
        int numElem = inEnd-inPos;

        root.right = helper(inorder,inPos+1,inEnd,postorder,pSt-1,hm);
        root.left = helper(inorder,inSt,inPos-1,postorder,pSt-numElem-1,hm);

        return root;
    }
}