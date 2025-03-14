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
        int carry = 0;
        ListNode temp = l1;
        ListNode curr = l1;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            l1.val =sum%10;
            curr = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // if l1 is less than l2 then add l2 to l1
        if(l1 == null){
            curr.next = l2;
            l1=l2;
        }
        while(l1!=null){
            int sum = l1.val + carry;
            carry = sum/10;
            l1.val =sum%10;
            curr = l1;
            l1 = l1.next;
        }
        if(carry!=0)
            curr.next = new ListNode(carry);
        return temp;
    }
}