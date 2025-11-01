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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> hs = new HashSet<>();
        for(int val : nums) hs.add(val);

        while(head != null){
            if(hs.contains(head.val)) head = head.next;
            else break;
        }

        ListNode node = head;

        while(node != null && node.next != null){
            while(node.next != null && hs.contains(node.next.val)){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
}