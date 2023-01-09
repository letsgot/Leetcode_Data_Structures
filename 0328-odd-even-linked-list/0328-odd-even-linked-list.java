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
    public ListNode oddEvenList(ListNode head) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        
        ListNode odd = d1;
        ListNode even = d2;
        ListNode curr = head;
        int i = 1;
        while(curr!=null){
            int val = curr.val;
            if(i%2==1){
                // odd
                odd.next = curr;
                odd = curr;
            }
            else{
                // even 
                even.next = curr;
                even = curr;
            }
            curr = curr.next;
            i++;
        }
        
            
        odd.next = d2.next;
        even.next = null;
        
        return d1.next;
    }
}