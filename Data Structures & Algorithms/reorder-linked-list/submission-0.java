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
    public void reorderList(ListNode head) {
        if(head == null) return;

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            nodes.add(cur);
            cur = cur.next;
        }

        int i = 0, j = nodes.size() - 1;
        while(i < j){
            ListNode n = nodes.get(i);
            ListNode nxt = n.next;
            ListNode last = nodes.get(j);

            n.next = last;
            last.next = nxt;
            i++;
            j--;
        }

        nodes.get(i).next = null;
    }
}
