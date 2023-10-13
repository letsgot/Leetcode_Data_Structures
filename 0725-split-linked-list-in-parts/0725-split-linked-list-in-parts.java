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
    public int size(ListNode curr){
        int sz = 0;
        while(curr!=null){
            sz++;
            curr = curr.next;
        }
        return sz;
    }
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = size(head);
        
        int q = size / k;
        int rem = size % k;
        
        ListNode [] ans = new ListNode[k];
        int i = 0;
        
        while(head!=null){
            int c = q + (rem>0?1:0);
            rem--;
            ans[i] = head;
            i++;
            while(head!=null&&c>0){
                if(c==1){
                    c--;
                    ListNode curr = head.next;
                    head.next = null;
                    head = curr;
                    continue;
                }
                head = head.next;
                c--;
            }
        }
        
        return ans;
    }
}