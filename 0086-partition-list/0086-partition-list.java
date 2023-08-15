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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(0);
        ListNode dummyGreater = new ListNode(0);
        
        ListNode curr = head;
        ListNode less = dummyLess;
        ListNode greater = dummyGreater;
        
        while(curr!=null){
            if(curr.val<x){
                less.next = curr;
                less = less.next;
            }
            else{
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        
        greater.next = null;
        
        less.next = dummyGreater.next;
        
        head = dummyLess.next;
        
       return head;   
    }
}