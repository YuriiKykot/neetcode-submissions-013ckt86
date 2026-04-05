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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }

        System.out.println(list.size());

        int target = list.size() - n;
        ListNode t = list.get(target);

        if(target != 0){
            ListNode i = list.get(target - 1);
            i.next = t.next;
        }

        t.next = null;
        list.remove(target);

        return list.size() > 0 ? list.get(0) : null;
    }
}
