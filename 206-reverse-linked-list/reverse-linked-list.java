class Solution {    
    public ListNode reverseList(ListNode head) {
        return revL(null,head);    
    }

    public ListNode revL(ListNode pre,ListNode cur){
        if(cur==null) // Tail of LinkedList 
            return pre; //because pre on last node and cur on null 
        ListNode nxt=cur.next; //store the reference to next Node
        cur.next=pre; //reversing Link
        return revL(cur,nxt); //Trust Recursion and apply it on current and next Node 
    }
}