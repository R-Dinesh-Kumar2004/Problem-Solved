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
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode newHead=reverse(head.next);
        ListNode t=head.next;
        t.next=head;
        head.next=null;
        return newHead;
    }
}