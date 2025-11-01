/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val+",");

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left == null){
                sb.append(-1+",");
            }
            else{
                sb.append(node.left.val+",");
                q.add(node.left);
            }

            if(node.right == null){
                sb.append(-1+",");
            }
            else{
                sb.append(node.right.val+",");
                q.add(node.right);
            }
        }
        return sb.substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())  return null;
        String str[] = data.split(",");

        int n = str.length;
        int nums[] = new int[n];
        for(int i=0;i<n;i++) nums[i] = Integer.parseInt(str[i]);

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;

        while(idx < n && !q.isEmpty()){
            TreeNode node = q.poll();

            if(nums[idx] != -1){
                TreeNode left = new TreeNode(nums[idx]);
                node.left = left;
                q.add(left);
            }
            idx++;

            if(idx < n && nums[idx] != -1){
                TreeNode right = new TreeNode(nums[idx]);
                node.right = right;
                q.add(right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;