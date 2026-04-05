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
    public boolean hasCycle(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while(cur != null){
            if(!list.contains(cur)){
                list.add(cur);
                cur = cur.next;
            }else{
                return true;
            }
        }

        return false;
    }
}
