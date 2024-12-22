/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> hm = new HashMap<>();
        int i=0;
        while(head!=null){
            if(hm.containsKey(head))return head;
            else hm.put(head,i);
            i++;
            head=head.next;
        }
        return head;
    }
}