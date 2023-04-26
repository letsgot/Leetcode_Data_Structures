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
    
    ListNode head;
    int size = 0;
    boolean check = true;
    public boolean isPalindrome(ListNode node) {
        head = node;
        size = siz(node);
        fold(1,node);
        return check;
    }
    
    public void fold(int sz,ListNode tail){
        if(tail==null){
            return;
        }
        fold(sz+1,tail.next);
        
        if(sz>size/2){
            if(head.val!=tail.val){
                check = false;
            }
            head = head.next;
        }
        
    }
    
    public int siz(ListNode n){
        int s =0;
        while(n!=null){
            s++;
            n = n.next;
        }
        return s;
    }
}