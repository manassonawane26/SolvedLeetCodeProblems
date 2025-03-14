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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if(head == null || n == 0)return head;
//         int length=1;
//         ListNode curr=head;
//         while(curr.next!=null){
//             curr=curr.next;
//             length++;
//         }
//         if(length==1 && n==1) return null;
//         n=length-n;
//         if(n==0) {head=head.next; return head;}
//         int count=1;
//         curr=head;
//         while(count<n){
//             curr=curr.next;
//             count++;
//         }
//         if(curr!=null && curr.next!=null)
//             curr.next=curr.next.next;
//         return head;
//     }
// }


// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if (head.next == null) {
    //         return null; 
    //     }
    //     ListNode curr = head; 
    //     int length = 0;
    //     while (curr != null) {
    //         curr = curr.next;
    //         length++; 
    //     }
    //     ListNode prev = null; 
    //     curr = head;
    //     for (int i = 0; i < length - n; i++) {
    //         prev = curr;
    //         curr = curr.next; 
    //     }
    //     if (prev == null) {
    //         head = head.next;
    //     } else { 
    //         prev.next = curr.next;
    //     }
    //     return head; 
    // }
// }


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy;
        ListNode second = dummy;
        while(first != null){
            first =  first.next;
            if(n < 0)
                second= second.next;
            n--;
        }
        if(second.next != null)
            second.next = second.next.next;
            
        return dummy.next;
    }
}