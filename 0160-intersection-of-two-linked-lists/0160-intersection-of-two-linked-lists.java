/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int sz1 = size(headA);
        int sz2 = size(headB);
        
        int diff = Math.abs(sz1-sz2);
        if(diff!=0){
            if(sz1>sz2){
                while(diff>0){
                    headA = headA.next;
                    diff--;
                }
            }
            else{
                while(diff>0){
                    headB = headB.next;
                    diff--;
                }
            }
        }
        
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int size(ListNode node){
        if(node==null){
            return 0;
        }
        int sz = 0;
        while(node!=null){
            sz++;
            node = node.next;
        }
        return sz;
    }
}