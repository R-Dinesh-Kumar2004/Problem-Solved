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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<n;i++){
            if(lists[i]!=null)pq.offer(lists[i]);
        }
        ListNode dummy=new ListNode(0);
        ListNode newHead=dummy;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            dummy.next=new ListNode(node.val);
            dummy=dummy.next;

            if(node.next!=null)pq.offer(node.next);
        }
        return newHead.next;
    }
}