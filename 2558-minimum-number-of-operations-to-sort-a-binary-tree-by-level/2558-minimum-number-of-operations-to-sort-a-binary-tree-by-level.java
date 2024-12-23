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
        int val;
        int idx;

        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public int minimumOperations(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int count=0;
        
        while(!q.isEmpty()){
            int n=q.size();
            Pair arr[]=new Pair[n];
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);
                arr[i]=new Pair(t.val,i);
            }
            Arrays.sort(arr,(a,b)->a.val-b.val);
            for(int i=0;i<n;i++){
                if(arr[i].idx!=i){
                    count++;
                    Pair t=arr[i];
                    arr[i]=arr[t.idx];
                    arr[t.idx]=t;
                    i--;
                }
            }
        }
        return count;
    }
}