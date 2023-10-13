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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode dummy = head;
        ListNode temp = dummy;
        int v = head.val;
        ListNode curr = head.next;
        
        while(curr!=null){
            if(curr.val==v){
                curr = curr.next;
            }
            else{
                v = curr.val;
                temp.next = curr;
                temp = temp.next;
                curr = curr.next;
            }
        }
        
        temp.next = null;
        
        return dummy;
    }
}