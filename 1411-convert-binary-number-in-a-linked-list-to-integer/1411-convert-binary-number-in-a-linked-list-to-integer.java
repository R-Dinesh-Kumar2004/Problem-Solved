/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode node = head;

        while(node != null){
            sb.append(node.val);
            node = node.next;
        }
        int ans = Integer.parseInt(sb.toString(),2);
        return ans;
    }
}