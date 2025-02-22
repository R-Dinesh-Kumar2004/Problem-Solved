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
    Map<Integer,Integer> hm = new HashMap<>();
    int maxFreq = -1;
    public int[] findFrequentTreeSum(TreeNode root) {
        rec(root);
        int n = 0;
        for(int freq : hm.values()){
            if(freq == maxFreq) n++;
        }
        int ans[] = new int[n];
        int idx = 0;
        for(int val : hm.keySet()){
            if(hm.get(val) == maxFreq){
                ans[idx++] = val;
            }
        }
        return ans;
    }
    public int rec(TreeNode root){
        if(root == null) return 0;

        int left = rec(root.left);
        int right = rec(root.right);

        int sum = left+right+root.val;
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        maxFreq = Math.max(maxFreq,hm.get(sum));

        return sum;
    }
}