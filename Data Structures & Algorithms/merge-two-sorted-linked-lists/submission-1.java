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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head;
        ListNode curr;

        if(curr1.val >= curr2.val){
            curr = curr2;
            curr2 = curr2.next;
            head = curr;
        }else {
            curr = curr1;
            curr1 = curr.next;
            head = curr;
        }

        while(curr1 != null || curr2 != null){
            if(curr1 == null || (curr2 != null && curr1.val >= curr2.val)){
                curr.next = curr2;
                curr2 = curr2.next;
            }else{
                curr.next = curr1;
                curr1 = curr1.next;
            }
            curr = curr.next;
        }

        return head;
    }
}