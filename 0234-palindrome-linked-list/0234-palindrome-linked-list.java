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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        
        ListNode mid = middleNode(head);
        
        ListNode right = reverse(mid);
        
        while(right!=null&&head!=mid){
            if(right.val!=head.val){
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        
        return prev;
    }
}