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
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        int carry = 0;
        while(l1!=null&&l2!=null){
            int v1 = l1.val;
            int v2 = l2.val;
            int val = (v1+v2+carry)%10;
            
            ListNode nn = new ListNode(val);
            temp.next = nn;
            temp = nn;
            
            carry = (v1+v2+carry)/10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
         while(l1!=null){
            int v1 = l1.val;
            // int v2 = l2.val;
            int val = (v1+carry)%10;
            
            ListNode nn = new ListNode(val);
            temp.next = nn;
            temp = nn;
            
            carry = (v1+carry)/10;
             
             
            l1 = l1.next;
            // l2 = l2.next;
        }
        
        while(l2!=null){
            int v1 = l2.val;
            // int v2 = l2.val;
            int val = (v1+carry)%10;
            
            ListNode nn = new ListNode(val);
            temp.next = nn;
            temp = nn;
            
            carry = (v1+carry)/10;
            
            
            // l1 = l1.next;
            l2 = l2.next;
        }
        
        if(carry!=0){
            ListNode nn = new ListNode(carry);
            temp.next = nn;
            temp = nn;
        }
        
        return dummy.next;
        
        
    }
    
    public ListNode reverse(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        
        ListNode curr = node;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        
        return prev;
    }
}