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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0,null);
        ListNode cur = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            ListNode n = new ListNode(sum % 10, null);
            cur.next = n;
            cur = n;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;

        // StringBuilder sb = new StringBuilder();
        // dfs(l1,sb);
        // String f1 = sb.toString();

        // sb = new StringBuilder();
        // dfs(l2,sb);
        // String f2 = sb.toString();

        // int sum = Integer.parseInt(f1) + Integer.parseInt(f2);
        // String res = String.valueOf(sum);

        // System.out.println(res);

        // ListNode head = new ListNode(res.charAt(res.length() - 1) - '0', null);
        // ListNode cur = head;

        // for (int i = res.length() - 2; i >= 0; i--) {
        //     ListNode n = new ListNode(res.charAt(i) - '0', null);
        //     cur.next = n;
        //     cur = n;
        // }

        // return head;
    }

    // public void dfs(ListNode node, StringBuilder sb) {
    //     if (node == null) {
    //         return;
    //     }

    //     dfs(node.next, sb);
    //     sb.append(node.val);
    // }
}
