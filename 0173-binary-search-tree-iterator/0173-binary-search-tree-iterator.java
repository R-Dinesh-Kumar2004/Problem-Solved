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
class BSTIterator {
    List<Integer> inList;
    int idx = -1;

    public BSTIterator(TreeNode root) {
        inList = new ArrayList<>();
        inorder(root,inList);
    }
    
    public int next() {
        idx++;
        return inList.get(idx);
    }
    
    public boolean hasNext() {
        return (idx+1 < inList.size());
    }
    public void inorder(TreeNode node, List<Integer> inList){
        if(node != null){
            inorder(node.left,inList);
            inList.add(node.val);
            inorder(node.right,inList);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */