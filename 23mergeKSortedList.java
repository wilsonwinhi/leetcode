/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if (curr != null) {
                pq.offer(curr);
                if (curr.next != null) {
                    curr = curr.next;
                    lists[i] = curr;
                }
            }
        }
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
            if (curr.next != null) {
                curr = curr.next;
                pq.offer(curr);
                
            }
        }
        return result.next;
    }
}
